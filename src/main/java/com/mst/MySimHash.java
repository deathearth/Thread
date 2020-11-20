package com.mst;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.hankcs.hanlp.dependency.nnparser.util.Log;
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
        content = Jsoup.clean(content, Whitelist.none());
        content = StringUtils.lowerCase(content);
        String[] strings = {" ", "\n", "\r", "\t", "\\r", "\\n", "\\t", "&nbsp;"};
        for (String s : strings) {
            content = content.replaceAll(s, "");
        }
        content = content.replaceAll("\\<img.*?\\>\r\n", "");
        System.out.println(content);
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

        String s1 = "realizeyour________________实现你的潜能1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"; 
        String s2 = "realize your___a_____________实现你的潜能1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        String s3 = "gateway.test.mistong.com/api/filecenter/fileService/file/782123620597817345 width=194 height=149/>\",\"<img  src=http://filegateway.test.mistong.com/api/filecenter/fileService/file/782123620597817346 width=194 height=154/>\",\"<img  src=http://filegateway.test.mistong.com/api/filecenter/fileService/file/782123620597817347 width=201 height=148/>\",\"<img  src=http://filegateway.test.mistong.com/api/filecenter/fileService/file/782123629187751936 width=204 height=148/>\"]";
//
//        long l3 = System.currentTimeMillis();
        MySimHash hash1 = new MySimHash(s1, 64);
        MySimHash hash2 = new MySimHash(s2, 64);
        
        System.out.println(hash1.strSimHash);
        System.out.println(hash2.strSimHash);
        MySimHash hash3 = new MySimHash(s3, 64);
        System.out.println(hash3.strSimHash);
////        MySimHash hash4 = new MySimHash(s4, 64);
////        MySimHash hash5 = new MySimHash(s5, 64);
//        System.out.println("======================================");
        System.out.println(  hash1.hammingDistance(hash2) );
        System.out.println(  hash2.hammingDistance(hash3) );
        System.out.println(  hash1.hammingDistance(hash3) );
////        System.out.println(  hash5.hammingDistance(hash4) );
////        System.out.println(  hash5.hammingDistance(hash3) );
//        
////        System.out.println(  hash1.getSemblance(hash3) );
////        System.out.println(  hash2.getSemblance(hash3) );
////        System.out.println(  hash3.getSemblance(hash4) );
//        long l4 = System.currentTimeMillis();
////        System.out.println(l4-l3);
//        System.out.println("======================================");
        
//        System.out.println(getDistance(new BigInteger("1488196069151293248"),new BigInteger("1487633119197871936")));
//        System.out.println(getDistance(new BigInteger("1488196069151293248"),new BigInteger("1487633119197625664")));
//        System.out.println(getDistance(new BigInteger("2469794738668645073"),new BigInteger("3469805065405543123")));
        

        
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


    private static int getDistance(BigInteger ahash, BigInteger bhash) {
        BigInteger m = new BigInteger("1").shiftLeft(64).subtract(
                new BigInteger("1"));
        BigInteger x = ahash.xor(bhash).and(m);
        int tot = 0;
        while (x.signum() != 0) {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }


}
