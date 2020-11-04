package com.mst;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.math.BigInteger;
import java.util.*;

public class MySimHash {
    private String tokens; //字符串
    private BigInteger strSimHash;//字符产的hash值
    private int hashbits = 64; // 分词后的hash数;


    public MySimHash(String tokens) {
        this.tokens = tokens;
        this.strSimHash = this.simHash();
    }

    private MySimHash(String tokens, int hashbits) {
        this.tokens = tokens;
        this.hashbits = hashbits;
        this.strSimHash = this.simHash();
    }


    /**
     * 清除html标签
     * @param content
     * @return
     */
    private String cleanResume(String content) {
        // 若输入为HTML,下面会过滤掉所有的HTML的tag
//        content = Jsoup.clean(content, Whitelist.none());
        content = StringUtils.lowerCase(content);
        String[] strings = {" ", "\n", "\r", "\t", "\\r", "\\n", "\\t", "&nbsp;"};
        for (String s : strings) {
            content = content.replaceAll(s, "");
        }
        return content;
    }


    /**
     * 这个是对整个字符串进行hash计算
     * @return
     */
    private BigInteger simHash() {

        tokens = cleanResume(tokens); // cleanResume 删除一些特殊字符

        int[] v = new int[this.hashbits];

        List<Term> termList = StandardTokenizer.segment(this.tokens); // 对字符串进行分词
        
        System.out.println(termList.toString());

        //对分词的一些特殊处理 : 比如: 根据词性添加权重 , 过滤掉标点符号 , 过滤超频词汇等;
        // 词性的权重
        Map<String, Integer> weightOfNature = new HashMap<>();
        //给名词的权重是2;
        weightOfNature.put("n", 2);
        //停用的词性 如一些标点符号之类的;
        Map<String, String> stopNatures = new HashMap<>();
        //
        stopNatures.put("w", "");
        //设定超频词汇的界限 ;
        int overCount = 5;
        Map<String, Integer> wordCount = new HashMap<>();

        for (Term term : termList) {
            //分词字符串
            String word = term.word;
            // 分词属性;
            String nature = term.nature.toString();
            //  过滤超频词
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                if (count > overCount) {
                    continue;
                }
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }

            // 过滤停用词性
            if (stopNatures.containsKey(nature)) {
                continue;
            }

            // 2、将每一个分词hash为一组固定长度的数列.比如 64bit 的一个整数.
            BigInteger t = this.hash(word);
            for (int i = 0; i < this.hashbits; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                // 3、建立一个长度为64的整数数组(假设要生成64位的数字指纹,也可以是其它数字),
                // 对每一个分词hash后的数列进行判断,如果是1000...1,那么数组的第一位和末尾一位加1,
                // 中间的62位减一,也就是说,逢1加1,逢0减1.一直到把所有的分词hash数列全部判断完毕.
                int weight = 1;  //添加权重
                if (weightOfNature.containsKey(nature)) {
                    weight = weightOfNature.get(nature);
                }
                if (t.and(bitmask).signum() != 0) {
                    // 这里是计算整个文档的所有特征的向量和
                    v[i] += weight;
                } else {
                    v[i] -= weight;
                }
            }
        }
        BigInteger fingerprint = new BigInteger("0");
        for (int i = 0; i < this.hashbits; i++) {
            if (v[i] >= 0) {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
            }
        }
        return fingerprint;
    }


    /**
     * 对单个的分词进行hash计算;
     * @param source
     * @return
     */
    private BigInteger hash(String source) {
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            /**
             * 当sourece 的长度过短，会导致hash算法失效，因此需要对过短的词补偿
             */
            while (source.length() < 3) {
                source = source + source.charAt(0);
            }
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(this.hashbits).subtract(new BigInteger("1"));
            for (char item : sourceArray) {
                BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }
            return x;
        }
    }

    /**
     * 计算海明距离,海明距离越小说明越相似;
     * @param other
     * @return
     */
    private int hammingDistance(MySimHash other) {
        BigInteger m = new BigInteger("1").shiftLeft(this.hashbits).subtract(
                new BigInteger("1"));
        BigInteger x = this.strSimHash.xor(other.strSimHash).and(m);
        int tot = 0;
        while (x.signum() != 0) {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }

    /**
     * 计算海明距离,海明距离越小说明越相似;
     * @param strSimHash
     * @return
     */
    public int hammingDistance(BigInteger strSimHash) {
        BigInteger m = new BigInteger("1").shiftLeft(this.hashbits).subtract(
                new BigInteger("1"));
        BigInteger x = this.strSimHash.xor(strSimHash).and(m);
        int tot = 0;
        while (x.signum() != 0) {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }


    public double getSemblance(MySimHash s2 ){
        double i =  this.hammingDistance(s2);
        return 1 - i/this.hashbits ;
    }

    public static void main(String[] args) {

        String s1 = "若<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936839873544192\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»a«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»+«/mo»«mover accent='true'»    «mi»b«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«mo stretchy='false'»(«/mo»«mo»&#x2212;«/mo»«mtext»6«/mtext»«mo»,«/mo»«mo»&#x2212;«/mo»«mtext»9«/mtext»«mo stretchy='false'»)«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamyyaaGa  ay51GaGaey4kaSYaa8HaaeaacaWGIbaacaGLxdcacqGH9aqppaGaai  ika8qacqGHsislcaqG2aGaaiilaiabgkHiTiaabMdapaGaaiykaaaa  @4BE4@  «/annotation» «/semantics»«/math»«/math»\"/>，<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936839873544193\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»a«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»&#x2212;«/mo»«mover accent='true'»    «mi»b«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«mo stretchy='false'»(«/mo»«mtext»7«/mtext»«mo»,«/mo»«mtext»4«/mtext»«mo stretchy='false'»)«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamyyaaGa  ay51GaGaeyOeI0Yaa8HaaeaacaWGIbaacaGLxdcacqGH9aqppaGaai  ikaiaabEdapeGaaiilaiaabsdapaGaaiykaaaa@4A11@  «/annotation» «/semantics»«/math»«/math»\"/>，则向量<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936848463478784\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»a«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamyyaaGa  ay51GaGaeyypa0daaa@42E1@  «/annotation» «/semantics»«/math»«/math»\"/><span class=\"mst-question-answer-placeholder\">1</span>, 向量<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936848463478786\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»b«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamOyaaGa  ay51GaGaeyypa0daaa@42E2@  «/annotation» «/semantics»«/math»«/math»\"/><span class=\"mst-question-answer-placeholder\">2</span>."; 
        String s2 = "若<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936917182955520\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»a«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»+«/mo»«mover accent='true'»    «mi»b«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«mo stretchy='false'»(«/mo»«mo»&#x2212;«/mo»«mn»3«/mn»«mo»,      «/mo»«mo»&#x2212;«/mo»«mn»4«/mn»«mo stretchy='false'»)«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamyyaaGa  ay51GaGaey4kaSYaa8HaaeaacaWGIbaacaGLxdcacqGH9aqppaGaai  ika8qacqGHsislcaaIZaGaaiilaiabgkHiTiaaisdapaGaaiykaaaa  @4BEA@  «/annotation» «/semantics»«/math»«/math»\"/>，<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936917182955521\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»a«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»&#x2212;«/mo»«mover accent='true'»    «mi»b«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«mo stretchy='false'»(«/mo»«mn»5«/mn»«mo»,«/mo»«mtext»3«/mtext»«mo stretchy='false'»)«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamyyaaGa  ay51GaGaeyOeI0Yaa8HaaeaacaWGIbaacaGLxdcacqGH9aqppaGaai  ika8qacaaI1aGaaiilaiaabodapaGaaiykaaaa@4A15@  «/annotation» «/semantics»«/math»«/math»\"/>，则向量<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936917182955522\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»a«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamyyaaGa  ay51GaGaeyypa0daaa@42E1@  «/annotation» «/semantics»«/math»«/math»\"/><span class=\"mst-question-answer-placeholder\">1</span>, 向量<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936917182955524\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»b«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamOyaaGa  ay51GaGaeyypa0daaa@42E2@  «/annotation» «/semantics»«/math»«/math»\"/><span class=\"mst-question-answer-placeholder\">2</span>.";
        String s3 = "若<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936917182955520\" data-mathml=\"\"/>，则向量<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936917182955522\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»a«/mi»    «mo stretchy='true'»&#x2192;«/mo»   «/mover»   «mo»=«/mo»«/mrow»  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakeaaqaaaaaaaaaWdbmaaFiaabaGaamyyaaGa  ay51GaGaeyypa0daaa@42E1@  «/annotation» «/semantics»«/math»«/math»\"/><span class=\"mst-question-answer-placeholder\">1</span>, 向量<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/769936917182955524\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math display='block'» «semantics»  «mrow»   «mover accent='true'»    «mi»b«/mi»    «mo stretchy='true'»&#x2192;.";

        long l3 = System.currentTimeMillis();
        MySimHash hash1 = new MySimHash(s1, 64);
        MySimHash hash2 = new MySimHash(s2, 64);
        MySimHash hash3 = new MySimHash(s3, 64);
//        MySimHash hash4 = new MySimHash(s4, 64);
//        MySimHash hash5 = new MySimHash(s5, 64);
        System.out.println("======================================");
        System.out.println(  hash1.hammingDistance(hash2) );
        System.out.println(  hash2.hammingDistance(hash3) );
        System.out.println(  hash1.hammingDistance(hash3) );
//        System.out.println(  hash5.hammingDistance(hash4) );
//        System.out.println(  hash5.hammingDistance(hash3) );
        
//        System.out.println(  hash1.getSemblance(hash3) );
//        System.out.println(  hash2.getSemblance(hash3) );
//        System.out.println(  hash3.getSemblance(hash4) );
        long l4 = System.currentTimeMillis();
//        System.out.println(l4-l3);
        System.out.println("======================================");

//        List<Question> questionList=new ArrayList<>();
//        String a2="";
//        String a1="这会儿应该怎么办";
//        
//
//        MySimHash n1 = new MySimHash(a1, 64);
////        MySimHash n2 = new MySimHash(a2, 64);
//
//        for(long i=0;i<10;i++){
//            Question question=new Question();
//            String str=a1+i;
//            MySimHash hhh = new MySimHash(str, 64);
//            question.setQuestionId(i);
//            question.setSimHash(hhh.strSimHash);
//            questionList.add(question);
//        }
//
//        long l4 = System.currentTimeMillis();
//        questionList.forEach(p->p.setDistance(n1.hammingDistance(p.getSimHash())));
//
//        questionList.forEach(v -> System.out.println(v.getSimHash().toString().length()));
//        
//         TopKList topKList=new TopKList(10);
//         for(Question a: questionList){
//             topKList.add(a);
//         }
////            System.err.println(topKList.sortedList());
////        max5(test,10);
////        new TopK().getTopKByHeap(test.toArray(new Integer[test.size()]), 10);
//        System.err.println("解析时间为"+( System.currentTimeMillis()-l4) +"ms");
//        System.err.println("内存占用大小为"+RamUsageEstimator.sizeOf(questionList)/1024L+"kb");

    }





}
