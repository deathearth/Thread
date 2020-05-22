package com.chl.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoup {
	
	public static final String qiniuCrawlerPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		String s = "<html lang=\"zh-CN\">\n" + 
				"<head>\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" + 
				"    <title>【1图】景区内民宿转让 口碑好客源稳定-缙云商铺租售/生意转让-丽水58同城</title>\n" + 
				"    <meta name=\"keywords\" content=\"丽水其他-临街转让,丽水其他-临街转让网,丽水其他-临街转让信息\" />\n" + 
				"	<meta http-equiv=\"mobile-agent\" content=\"format=xhtml; url=https://m.58.com/lishui//41672676882832x.shtml\">\n" + 
				"<meta http-equiv=\"mobile-agent\" content=\"format=html5; url=https://m.58.com/lishui//41672676882832x.shtml\">\n" + 
				"<meta http-equiv=\"mobile-agent\" content=\"format=wml; url=https://m.58.com/lishui//41672676882832x.shtml\">\n" + 
				"<script type=\"application/ld+json\">\n" + 
				"    {\n" + 
				"        \"@context\": \"https://ziyuan.baidu.com/contexts/cambrian.jsonld\",\n" + 
				"        \"@id\": \"https://infodetail1.58.com/lishui/shangpu/41672676882832x.shtml?adtype=590\",\n" + 
				"        \"pubDate\": \"2020-04-24T16:44:31.000Z\"\n" + 
				"    }\n" + 
				"</script>	<meta name=\"location\" content=\"province=丽水;city=缙云; \"/>\n" + 
				"    <link type=\"text/css\" rel=\"stylesheet\" href=\"//c.58cdn.com.cn/componentsLoader/dist/CompontsLoader_v20200514200101.css\" media=\"all\"/>\n" + 
				"    <link rel=\"stylesheet\" href=\"//c.58cdn.com.cn/ui7/css/easydialog_v20200405002559.css\" />\n" + 
				"    <link rel=\"stylesheet\" href=\"//c.58cdn.com.cn/frs/fangfe/pc-site-ts/1.11/business-detail-sp/main_v20200518142732.css\" />\n" + 
				"    <link rel=\"stylesheet\" href=\"//c.58cdn.com.cn/crop/biz/pc/entrance/commercial_peg_v20191017170251.css\" />\n" + 
				"    <!-- 页面基本的信息和配置 -->\n" + 
				"    <script>\n" + 
				"	    try {\n" + 
				"\n" + 
				"	        var __baseInfo = {\n" + 
				"                cityInfo: {\"pinyin\":\"lishui\",\"name\":\"丽水\",\"id\":7921,\"type\":1,\"parentId\":0},\n" + 
				"                categoryEntity: {\"filter\":\"\",\"fullPath\":\"1,14\",\"depth\":1,\"cateID\":14,\"pID\":1,\"listName\":\"shangpu\",\"businessType\":0,\"cateName\":\"商铺租售/生意转让\",\"dispCategoryID\":14,\"order\":7},\n" + 
				"                districtInfo: {\"pinyin\":\"jinyunqu\",\"name\":\"缙云\",\"id\":7925,\"type\":2,\"parentId\":7921},\n" + 
				"                blockInfo: {},\n" + 
				"                infoId: \"41672676882832\",\n" + 
				"                address: \"仙都国家级风景名胜区\",\n" + 
				"                propId: \"\",\n" + 
				"            };\n" + 
				"\n" + 
				"	        var __brokerInfo = {\"brokerId\":0,\"phoneRegPlace\":\"丽水\",\"type\":1,\"headPic\":\"https://pic1.58cdn.com.cn/m1/bigimage/n_v28facaa6624f046eb9a6615f0ade9b08d.jpg\",\"jumpUrl\":\"https://my.58.com/person/35009863021578?personType=1&cateId=14&type=3&cityId=7921&brokerId=\",\"isRealNameAuth\":true,\"phone\":\"15168018868\",\"identity\":\"个人\",\"registerStr\":\"已在58注册5年\",\"name\":\"郑先生\",\"id\":35009863021578};\n" + 
				"\n" + 
				"            var ____json4fe = {\"_trackURL\":\"{\\\"anxuan\\\":0,\\\"area\\\":\\\"7921,7925\\\",\\\"business_type\\\":\\\"zhuanrang\\\",\\\"cate\\\":\\\"1,14,27442\\\",\\\"cateBusiness\\\":\\\"1,14,27442,27461\\\",\\\"city\\\":\\\"7921\\\",\\\"infoSource\\\":2,\\\"infolabel\\\":\\\"[null]\\\",\\\"is_biz\\\":false,\\\"is_real\\\":false,\\\"is_vip\\\":false,\\\"page\\\":\\\"\\\",\\\"pagetype\\\":\\\"detail\\\",\\\"product\\\":\\\"[null]\\\",\\\"shopid\\\":\\\"\\\",\\\"source\\\":0,\\\"stats\\\":0,\\\"type\\\":\\\"[mianfei]\\\",\\\"userid\\\":0}\",\"catentry\":{\"name\":\"\\u5546\\u94fa\\u79df\\u552e/\\u751f\\u610f\\u8f6c\\u8ba9\",\"listname\":\"shangpu\",\"dispid\":14},\"infoid\":41672676882832,\"is_huzhuan\":\"false\",\"isbiz\":false,\"isport\":false,\"linkman\":\"\\u90d1\\u5148\\u751f\",\"locallist\":[{\"name\":\"\\u4e3d\\u6c34\",\"listname\":\"lishui\",\"dispid\":7921},{\"name\":\"\\u7f19\\u4e91\",\"listname\":\"jinyunqu\",\"dispid\":7925}],\"modules\":\"finalpage\",\"phone\":\"15****886\",\"req_version\":\"1.0.0\",\"rootcatentry\":{\"name\":\"\\u623f\\u4ea7\\u4fe1\\u606f\",\"listname\":\"house\",\"dispid\":1},\"shipin\":\"\",\"slotIds\":\"8,16,1000170,1000014,1000015,1000016,1000017,1000018\",\"ssp_abtest\":\"legoC_fc\",\"start\":1590118021284,\"trackURL\":{\"anxuan\":0,\"area\":\"7921,7925\",\"business_type\":\"zhuanrang\",\"cate\":\"1,14,27442\",\"cateBusiness\":\"1,14,27442,27461\",\"city\":\"7921\",\"infoSource\":2,\"infolabel\":\"[null]\",\"is_biz\":false,\"is_real\":false,\"is_vip\":false,\"page\":\"\",\"pagetype\":\"detail\",\"product\":\"[null]\",\"shopid\":\"\",\"source\":0,\"stats\":0,\"type\":\"[mianfei]\",\"userid\":0},\"userid\":35009863021578,\"xiaoqu\":{\"baidulat\":28.696227,\"baidulon\":120.147137,\"dizhi\":\"\\u4ed9\\u90fd\\u56fd\\u5bb6\\u7ea7\\u98ce\\u666f\\u540d\\u80dc\\u533a\"}};\n" + 
				"\n" + 
				"            ____json4fe.modules = 'finalpage';\n" + 
				"            ____json4fe.sid = 145818286208419949285564899;\n" + 
				"            //获取cookie\n" + 
				"            ____json4fe.sessionid = '';\n" + 
				"            ____json4fe.newImVersion = true;\n" + 
				"            ____json4fe.vrFlag =  false;\n" + 
				"            ____json4fe.videoFlag =  false ;\n" + 
				"\n" + 
				"            ____json4fe.baiduMap = {\n" + 
				"                lat: 28.696227,\n" + 
				"                lng: 120.147137,\n" + 
				"            };\n" + 
				"\n" + 
				"            // 猜你喜欢新增\n" + 
				"            ____json4fe.guessInfoId = \"41672676882832\";\n" + 
				"            ____json4fe.guessDispId = \"7921\";\n" + 
				"            ____json4fe.guessProTypeName = \"生意转让\";\n" + 
				"            ____json4fe.posterInfoType = \"1\"; // 发帖人类型\n" + 
				"            ____json4fe.starScore = \"\"; // 经纪人女神分\n" + 
				"\n" + 
				"            // 二维码 微信拨号\n" + 
				"            ____json4fe.wxQRcodeUrl = \"https://pic1.58cdn.com.cn/nowater/58sydc_qrcode/n_v2ad8e2addf513466a9e99226649c50a8c.jpg\";\n" + 
				"            // 房源是否过期\n" + 
				"            ____json4fe.houseIsPastDue = false;\n" + 
				"            // 个人隐私通话 城市灰度开关\n" + 
				"            ____json4fe.privacyCallFlag = \"\";\n" + 
				"            // 埋点类别区分\n" + 
				"            ____json4fe.tongji_tag = \"fcpc_shangpu_detail_\";\n" + 
				"\n" + 
				"            var sojInfo = \"p=sydc_58_pc_shangpu_detail&pn=sydc_58_pc_shangpu_detail&site=wuba&guid=e87rZl7HRievTXRhDlRPAg%3D%3D&h=https%3A%2F%2Finfodetail1.58.com%2Flishui%2Fshangpu%2F41672676882832x.shtml&t=1590118021290&ssid=E9C8A61F560343ABA35797A6350C6757&uid=0&ctid=7921&plat=1&type=1&ep=&r=&cp=%7B%22COMMID%22%3A0%2C%22agent%22%3A%22Mozilla%2F5.0+%28Macintosh%3B+Intel+Mac+OS+X+10_14_6%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F83.0.4103.61+Safari%2F537.36%22%2C%22brokerId%22%3A0%2C%22brokerType%22%3A2%2C%22channel%22%3A0%2C%22cookie%22%3A%22e87rZl7HRievTXRhDlRPAg%3D%3D%22%2C%22entry%22%3A1%2C%22hpType%22%3A60%2C%22invalid%22%3A%220%22%2C%22ip%22%3A%221.199.187.120%22%2C%22localId%22%3A%227925%22%2C%22proId%22%3A41672676882832%2C%22tradeType%22%3A14%2C%22uniqid%22%3A%22145818286208419949285564899%22%2C%22userId%22%3A0%2C%22userType%22%3A0%2C%22v%22%3A%222.0%22%7D\";\n" + 
				"            var searchUrl = \"https://lishui.58.com/shengyizr/?newSearch=1&key=\";\n" + 
				"\n" + 
				"	    }catch(e){}\n" + 
				"        document.domain = '58.com';\n" + 
				"    </script>\n" + 
				"    <!-- 百度地图 -->\n" + 
				"    <script type=\"text/javascript\" charset=\"utf-8\" data-requirecontext=\"_\" data-requiremodule=\"baiduMap\" src=\"//api.map.baidu.com/api?v=3.0&ak=hSgcmoa2WrW5xhHWKSkDgHi3\"></script>\n" + 
				"    <script src=\"//j1.58cdn.com.cn/frs/fangfe/pc-site-ts/1.5/vendor_detail_v20191211143800.js\"></script>\n" + 
				"    <script src=\"//j1.58cdn.com.cn/js/login/floatLayerLogin_v20180921162133.js\"></script>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<!-- 公共头部start -->\n" + 
				"<div id=\"commonTopbar\" class=\"commonTopbar\"></div>\n" + 
				"<!-- 公共头部end -->\n" + 
				"<!-- 顶部广告start-->\n" + 
				"<div id=\"brand_detial_top_banner\"  class=\"brandad1000\"></div>\n" + 
				"<!-- 顶部广告end-->\n" + 
				"<!--头部start-->\n" + 
				"<div class=\"header-wrap clearfix\">\n" + 
				"    <a class=\"logo fl\" href=\"//lishui.58.com/\" target=\"_blank\" onclick=\"clickLog('from=fcpc_shangpu_detail_logo')\"></a>\n" + 
				"    <a class=\"top-publish-news fr\" href=\"//post.58.com/commercial/7921/14/s5\" target=\"_blank\" onclick=\"clickLog('from=fcpc_shangpu_detail_fabu')\">免费发布</a>\n" + 
				"    <div class=\"search-section\">\n" + 
				"        <input \n" + 
				"            class='search-input' \n" + 
				"            type=\"text\" \n" + 
				"            value=\"\" \n" + 
				"            fdv=\"\" \n" + 
				"            id=\"keyword1\" \n" + 
				"            name=\"b_q\" \n" + 
				"            para=\"key\" \n" + 
				"            autocomplete=\"off\"\n" + 
				"        >\n" + 
				"        <i class='icon'></i>\n" + 
				"        <span class='search-btn' id='searchBtn'>搜房源</span>\n" + 
				"        <ul class='search-infolist' id='searchList'>\n" + 
				"        </ul>\n" + 
				"    </div>\n" + 
				"    <div class=\"nav-top-bar fl c_888 f12\">\n" + 
				"        <a href=\"//lishui.58.com/\" target=\"_blank\" onclick=\"clickLog('from=fcpc_shangpu_detail_miaobaoxie@crumbs=1')\">丽水58同城 </a>>\n" + 
				"        <a href=\"//lishui.58.com/house.shtml\" target=\"_blank\" onclick=\"clickLog('from=fcpc_shangpu_detail_miaobaoxie@crumbs=2')\">丽水房产信息</a>>\n" + 
				"        <a href=\"//lishui.58.com/shangpu/\" target=\"_blank\" onclick=\"clickLog('from=fcpc_shangpu_detail_miaobaoxie@crumbs=3')\">丽水商铺租售/生意转让</a>\n" + 
				"                    >&nbsp;<a href=\"//lishui.58.com/jinyunqu/shangpu/\" target=\"_blank\" onclick=\"clickLog('from=fcpc_shangpu_detail_miaobaoxie@crumbs=4')\">缙云商铺租售/生意转让</a>\n" + 
				"                    </div>\n" + 
				"</div>\n" + 
				"<!--头部end--><!--房源信息start-->\n" + 
				"<div class=\"main-wrap\">\n" + 
				"    <!--房源标题start-->\n" + 
				"    <div class=\"house-title\">\n" + 
				"        <h1 class=\"c_000 f20\">(转让)&nbsp;景区内民宿转让 口碑好客源稳定</h1>\n" + 
				"        <p class=\"house-update-info\">\n" + 
				"            \n" + 
				"                                        <span style=\"background: rgba(40, 160, 50, 0.1); color: #28A032;\">酒店宾馆</span>\n" + 
				"                            <span style=\"background: rgba(241, 168, 42, 0.1); color: #F1A82A;\">其他</span>\n" + 
				"                            <span style=\"background: #F5F5F5; color: #7A96B8;\">临街</span>\n" + 
				"                            <span style=\"background: #F5F5F5; color: #7A96B8;\">上水</span>\n" + 
				"                            <span style=\"background: #F5F5F5; color: #7A96B8;\">下水</span>\n" + 
				"                            <span style=\"background: #F5F5F5; color: #7A96B8;\">外摆区</span>\n" + 
				"                        <span class='up'>更新于2020-04-24</span>\n" + 
				"            <span class='up'>72人已浏览</span>\n" + 
				"        </p>\n" + 
				"        <div class=\"title-right-info f12\">\n" + 
				"            <a id=\"collectHouseTop\" class=\"collect-house c_999 on ml_20 clt-btn\" href=\"javascript:;\" onclick=\"clickLog('from=fcpc_shangpu_detail_shoucang@location=1@collection=1')\">\n" + 
				"                <div class='top c_555 f14 lh18'><i class=\"collectIcon icon\"></i>收藏</div>\n" + 
				"                <em id='collectCount'>0</em>人气</a>\n" + 
				"            <a id=\"defraudHouse\" class=\"defraud-house c_888 ml_20\" href=\"javascript:;\"><i class=\"defraudIcon icon\"></i>举报</a>\n" + 
				"        </div>\n" + 
				"        <div id=\"reportBar\" class=\"report-column pr\" style=\"display: none;\">\n" + 
				"            <i class=\"jianjiao icon\"></i>\n" + 
				"            <a class=\"ab\" href=\"//about.58.com/info/deleteinfo.aspx\" target=\"_blank\" onclick=\"clickLog('fcpc_shangpu_detail_jubao@name=1')\">电话被冒用</a>\n" + 
				"            <a class=\"ab\" href=\"https://about.58.com/vote/entrance?sceneid=17&param=%2FyXzdp0vF%2FCvLpRAX9l7QYM02YS%2Fhdqu%2B7aTZSR%2Fv5%2F7k6Tn0nWaTSWJi3T0MnmR\" onclick=\"clickLog('from=fcpc_shangpu_detail_jubao@name=2')\"\n" + 
				"               target=\"_blank\">信息虚假</a>\n" + 
				"            <a class=\"ab\" href=\"//110.58.com/?postId=41672676882832&amp;category=1001\" onclick=\"clickLog('from=fcpc_shangpu_detail_jubao@name=3')\"\n" + 
				"               target=\"_blank\">我要报案</a>\n" + 
				"        </div>\n" + 
				"    </div>\n" + 
				"    <!--房源标题end-->\n" + 
				"    <!--房源基本信息start-->\n" + 
				"    <div class=\"house-basic-info clearfix\">\n" + 
				"        <div class=\"house-basic-pic fl\" id='houseBasicPic'>\n" + 
				"            <div id=\"bigImg\" class=\"basic-top-bigpic pr \" onclick=\"clickLog('from=fcpc_shangpu_detail_datu')\">\n" + 
				"                                                <!-- 全景加1 start -->\n" + 
				"                                <!-- 全景加1 end -->\n" + 
				"                <!-- 视频加1 start -->\n" + 
				"                                <!-- 视频加1 end -->\n" + 
				"                <img id=\"smainPic\" src=\"https://pic8.58cdn.com.cn/mobile/big/n_v2bfb7c82997df41a9b29a97e4987de304.jpg?w=640&h=480&crop=1\">\n" + 
				"                <div class=\"basic-pic-load\" id=\"loadingSmall\">\n" + 
				"                    <div class=\"top icon\"></div>\n" + 
				"                    <div class=\"bottom icon\"></div>\n" + 
				"                </div>\n" + 
				"                <!-- 视频加2 start -->\n" + 
				"                                <!-- 视频加2 end -->\n" + 
				"                <!-- VR start -->\n" + 
				"                                <!-- VR end -->\n" + 
				"            </div>\n" + 
				"            <div class=\"basic-pic-list pr\">\n" + 
				"                <ul id=\"leftImg\" class=\"pic-list-wrap pa\">\n" + 
				"                                                                        <li id=\"xtu_0\" class=\"actives\" data-value=\"https://pic8.58cdn.com.cn/mobile/big/n_v2bfb7c82997df41a9b29a97e4987de304.jpg?w=640&h=480&crop=1\">\n" + 
				"                                                                <img data-value=\"https://pic8.58cdn.com.cn/mobile/big/n_v2bfb7c82997df41a9b29a97e4987de304.jpg?w=182&h=150&crop=1\" src=\"https://pic8.58cdn.com.cn/mobile/big/n_v2bfb7c82997df41a9b29a97e4987de304.jpg?w=182&h=150&crop=1\">\n" + 
				"                            </li>\n" + 
				"                                                                                        </ul>\n" + 
				"                <a id=\"slbt\" class=\"basic-pic-left pa\" href=\"javascript:void(0);\" onclick=\"clickLog('from=fcpc_shangpu_detail_nextpic')\">\n" + 
				"                    <i class='icon'></i>\n" + 
				"                </a>\n" + 
				"                <a id=\"srbt\" class=\"basic-pic-right pa\" href=\"javascript:void(0);\" onclick=\"clickLog('from=fcpc_shangpu_detail_nextpic')\">\n" + 
				"                    <i class='icon'></i>\n" + 
				"                </a>\n" + 
				"            </div>\n" + 
				"        </div>\n" + 
				"        <div class=\"house-basic-right fr\">\n" + 
				"            <p class=\"house_basic_title_money\">\n" + 
				"                <span class=\"house_basic_title_money_num\">4100</span>\n" + 
				"                <span class=\"house_basic_title_money_unit\">元/月</span>\n" + 
				"                                                            <span class=\"house_basic_title_money_num_second\">转让费：68万元&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" + 
				"                                        <a class=\"quick-daikuan\" href=\"//jinrong.58.com/k?from=58_jinrong_fc_syzr\" target=\"_blank\">快速贷款 ></a>\n" + 
				"                            </p>\n" + 
				"            <p class=\"house_basic_title_info\">\n" + 
				"                <span class=\"up\">360m²</span>\n" + 
				"                <span class=\"up\">其他</span>\n" + 
				"                <span class=\"up\">\n" + 
				"                                            80个月\n" + 
				"                                    </span>\n" + 
				"                <span>建筑面积</span>\n" + 
				"                <span>物业类型</span>\n" + 
				"                <span>\n" + 
				"                                            剩余租期\n" + 
				"                                    </span>\n" + 
				"            </p>  \n" + 
				"            <div class=\"house_basic_title_info_2\">\n" + 
				"                                    <p>\n" + 
				"                        <span class=\"title\">区&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;域：</span>\n" + 
				"                        缙云区                     </p> \n" + 
				"                    <p class=\"p_2\">\n" + 
				"                        <span class=\"title\">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</span>\n" + 
				"                        <span class=\"address\">仙都国家级风景名胜区</span>\n" + 
				"                        <a href=\"javascript:void(0)\" jumpto=\"mapWrap\" class=\"map\"><i></i>地图</a>\n" + 
				"                    </p>\n" + 
				"                            </div>\n" + 
				"\n" + 
				"            <!-- 发帖人信息展示start -->\n" + 
				"            <div class=\"house-basic-poster-wrapper\">\n" + 
				"            <!-- 1:免费个人和2:免费经纪人3:商业个人房东 -->\n" + 
				"        <a class=\"poster-img\" href='https://my.58.com/person/35009863021578?personType=1&cateId=14&type=3&cityId=7921&brokerId=' traget=\"_blank\" onclick=\"clickLog('from=fcpc_shangpu_detail_geren')\">\n" + 
				"            <img src=\"https://pic1.58cdn.com.cn/m1/bigimage/n_v28facaa6624f046eb9a6615f0ade9b08d.jpg\" alt=\"郑先生\">\n" + 
				"        </a>\n" + 
				"        <div class=\"poster-name\">\n" + 
				"            <span class=\"name-text\">郑先生</span>\n" + 
				"                    </div>\n" + 
				"        <p class=\"poster-identity\">个人</p>\n" + 
				"        <p class=\"poster-register\">已在58注册5年</p>\n" + 
				"                <p class=\"realNameAuth\"><i class=\"yes\"></i><span class=\"yes\">已实名认证</span></p>\n" + 
				"            </div>            <!-- 发帖人信息展示end -->\n" + 
				"\n" + 
				"            <!-- 微信扫码拨号start -->\n" + 
				"                        <div class=\"mnp-qr \">\n" + 
				"                <img class=\"qr\" src=\"https://pic1.58cdn.com.cn/nowater/58sydc_qrcode/n_v2bd89493caf8c483f8e3bd8e03669adc1.jpg\" alt=\"微信扫码拨号\">\n" + 
				"                                    <p>微信扫码咨询</p>\n" + 
				"                            </div>\n" + 
				"                        <!-- 微信扫码拨号end -->\n" + 
				"                            <div class=\"house-chat-entry clearfix\" id='houseChatEntry'>\n" + 
				"                                            <!-- 点击显示号码 有气泡 -->\n" + 
				"                        <div class=\"house-chat-phone\">\n" + 
				"                            <p class='phone-num phone-after-click' style=\"display: none;\">15168018868</p>\n" + 
				"                                              \n" + 
				"              <p class='phone-belong phone-after-click' style=\"display: none;\">\n" + 
				"                                    <span>电话归属地 : </span>\n" + 
				"                                    <span>丽水</span>\n" + 
				"                                </p>\n" + 
				"                                                        <i class=\"phone-before-click-icon\"></i>\n" + 
				"                            <!-- 兼容二维码无法生成 -->\n" + 
				"                            <span class=\"phone-before-click-title\">电话联系TA</span>\n" + 
				"                        </div>\n" + 
				"                                        <div class=\"house-chat-wechat\">\n" + 
				"                        <i></i>\n" + 
				"                        <span>扫一扫，进详情</span>\n" + 
				"                    </div>\n" + 
				"                    <a href='javascript:;' class=\"house-chat-im im-chat im-offline im-off\" data-im=\"%7B%22infoType%22%3A5%2C%22cateid%22%3A14%2C%22cate_extra%22%3A%7B%22cateBusiness_tag%22%3A%22shengyizr_null%22%2C%22cateBusiness%22%3A%221%2C14%2C27442%2C27461%22%7D%2C%22usersource%22%3A%222%22%2C%22postid%22%3A41672676882832%2C%22userid%22%3A35009863021578%2C%22rootcateid%22%3A1%7D\"\n" + 
				"                       onclick=\"clickLog('from=fcpc_shangpu_detail_IM')\" tongji_tag=\"shengyizr_null_IM\">\n" + 
				"                        <i class=\"im-icon icon\"></i>在线沟通\n" + 
				"                    </a>\n" + 
				"                </div>\n" + 
				"                    </div>\n" + 
				"    </div>\n" + 
				"    <!--房源基本信息end-->\n" + 
				"    <!--房源详情start-->\n" + 
				"    <div class=\"house-detail-info\">\n" + 
				"        <div class=\"house-detail-right\">\n" + 
				"            <!-- 猜你喜欢 start -->\n" + 
				"            <div id=\"guessLikeRight\"></div>\n" + 
				"            <!-- 猜你喜欢 end -->\n" + 
				"            <!-- 经纪人信息 -->\n" + 
				"            <!-- <div class=\"side-right-wrapper agent-info\" id=\"agent-info\"></div> -->\n" + 
				"            <!-- 左侧其他人还在看 -->\n" + 
				"            <div id=\"sideAD\"></div>\n" + 
				"            <!-- 土巴兔 -->\n" + 
				"            <div style=\"text-align: center;height:200px;margin-top:20px;width:200px;\">\n" + 
				"                <a href=\"https://www.to8to.com/yezhu/zxbj.php?to8to_from=diff_fcpd\" target=\"_blank\">\n" + 
				"                    <img src=\"https://pic4.58cdn.com.cn/nowater/fangfe/n_v201a4d9a7967f4a7d87a312316b65a8b9.jpg\" alt=\"土巴兔\">\n" + 
				"                </a>\n" + 
				"            </div>\n" + 
				"        </div>\n" + 
				"        <div class=\"house-detail-left\">\n" + 
				"            <!-- 固定导航条 start -->\n" + 
				"            <div class=\"house-origin-nav\" id='originNav'>\n" + 
				"                <ul class='nav-menu'>\n" + 
				"                    <li class='cur' jumpto=\"intro\" onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=4@location=1')\">概况</li>\n" + 
				"                    <li  jumpto='generalSound' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=2@location=1')\">描述</li>\n" + 
				"                                        <li jumpto='peitao' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=1@location=1')\">配套</li>\n" + 
				"                                                            <li jumpto='generalType' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=3@location=1')\">图片</li>\n" + 
				"                                        <li jumpto='loupanWrap' class=\"loupan-nav\" onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=4@location=1')\">楼盘</li>\n" + 
				"                                            <li jumpto='mapWrap' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=5@location=1'')\">位置</li>\n" + 
				"                                                            <li jumpto='questionWrap' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=6@location=2')\">楼盘问答</li>\n" + 
				"                                    </ul>\n" + 
				"            </div>\n" + 
				"            <!-- 固定导航条 end -->\n" + 
				"            <!-- 概况 -->\n" + 
				"            <div class=\"general-item general-intro\" id='intro'>\n" + 
				"                <h3><em></em>概况<a href=\"//post.58.com/commercial/7921/14/s5\" class=\"general-fabu-link\" onclick=\"clickLog('from=fcpc_shangpu_detail_publish_click')\" target=\"_blank\">我有类似房源，免费发布></a></h3>\n" + 
				"                <ul class=\"general-item-wrap\">\n" + 
				"                                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">月租</span>\n" + 
				"                        <span class=\"content\">4100元/月</span>\n" + 
				"                    </li>\n" + 
				"                                        <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">转让费</span>\n" + 
				"                        <span class=\"content\">\n" + 
				"                                                    68万元\n" + 
				"                                                </span>\n" + 
				"                    </li>\n" + 
				"                                        <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">押付</span>\n" + 
				"                        <span class=\"content\">押0付80</span>\n" + 
				"                    </li>\n" + 
				"                                        <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">剩余租期</span>\n" + 
				"                        <span class=\"content\">80个月</span>\n" + 
				"                    </li>\n" + 
				"                                        <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">建筑面积</span>\n" + 
				"                        <span class=\"content\">360m²</span>\n" + 
				"                    </li>\n" + 
				"                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">商铺性质</span>\n" + 
				"                        <span class=\"content\">二手房</span>\n" + 
				"                    </li>\n" + 
				"                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">商铺类型</span>\n" + 
				"                        <span class=\"content\">其他-临街</span>\n" + 
				"                    </li>\n" + 
				"                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">经营状态</span>\n" + 
				"                        <span class=\"content\">经营中</span>\n" + 
				"                    </li>\n" + 
				"                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">经营类型</span>\n" + 
				"                        <span class=\"content\">酒店宾馆-宾馆酒店</span>\n" + 
				"                    </li>\n" + 
				"                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">楼层</span>\n" + 
				"                        <span class=\"content\">独栋/共4层</span>\n" + 
				"                    </li>\n" + 
				"                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">规格</span>\n" + 
				"                        <span class=\"content\">面宽7.5m、层高2.8m、进深12m</span>\n" + 
				"                    </li>\n" + 
				"                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">客流人群</span>\n" + 
				"                        <span class=\"content\">旅游、其他、居民、学生、办公</span>\n" + 
				"                    </li>\n" + 
				"                    <li class=\"intro-item\">\n" + 
				"                        <span class=\"title\">相关费用</span>\n" + 
				"                        <span class=\"content\">物业费1元/m²/月,电费1元/度,水费2元/吨</span>\n" + 
				"                    </li>\n" + 
				"                                </ul>\n" + 
				"            </div>\n" + 
				"            <!-- 概况 -->\n" + 
				"            <!-- 描述 start -->\n" + 
				"            <div class=\"general-item general-miaoshu\" id='generalSound'>\n" + 
				"                <h3><em></em>描述</h3>\n" + 
				"                <div class=\"general-item-wrap\">\n" + 
				"                    近景区 周边环境好  民宿经营状态好  口碑客源好  因家里有事忍痛转\n" + 
				"                    <br><br><p name=\"data_2\">联系我时，请说是在58同城上看到的，谢谢！</p>\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"            <!-- 描述 end -->\n" + 
				"            <!-- 配套 start -->\n" + 
				"                        <div class=\"general-item general-peitao\" id='peitao'>\n" + 
				"                <h3><em></em>配套</h3>\n" + 
				"                <span class=\"fold-tag\">展开<i class=\"down\"></i></span>\n" + 
				"                <div class=\"general-item-wrap\">\n" + 
				"                    <ul class=\"peitao-icon\">\n" + 
				"                                                	                                                        <li class=\"peitao-on\"><i class=\"icon1\"></i>网络</li>\n" + 
				"                                                	                                                        <li class=\"peitao-off\"><i class=\"icon2\"></i>暖气</li>\n" + 
				"                                                	                                                        <li class=\"peitao-off\"><i class=\"icon3\"></i>天燃气</li>\n" + 
				"                                                	                                                        <li class=\"peitao-on\"><i class=\"icon4\"></i>上水</li>\n" + 
				"                                                	                                                        <li class=\"peitao-on\"><i class=\"icon5\"></i>下水</li>\n" + 
				"                                                	                                                        <li class=\"peitao-on\"><i class=\"icon6\"></i>排烟</li>\n" + 
				"                                                	                                                        <li class=\"peitao-on\"><i class=\"icon7\"></i>排污</li>\n" + 
				"                                                	                                                        <li class=\"peitao-off\"><i class=\"icon8\"></i>管煤</li>\n" + 
				"                                                	                                                        <li class=\"peitao-on\"><i class=\"icon9\"></i>停车位</li>\n" + 
				"                                                	                                                        <li class=\"peitao-off\"><i class=\"icon10\"></i>380v</li>\n" + 
				"                                                	                                                        <li class=\"peitao-on\"><i class=\"icon11\"></i>扶梯</li>\n" + 
				"                                                	                                                        <li class=\"peitao-off\"><i class=\"icon12\"></i>货梯</li>\n" + 
				"                                                	                                                        <li class=\"peitao-off\"><i class=\"icon13\"></i>客梯</li>\n" + 
				"                                                	                                                        <li class=\"peitao-off\"><i class=\"icon14\"></i>中央空调</li>\n" + 
				"                                                	                                                        <li class=\"peitao-on\"><i class=\"icon15\"></i>外摆区</li>\n" + 
				"                                                	                                                        <li class=\"peitao-off\"><i class=\"icon16\"></i>可明火</li>\n" + 
				"                                            </ul>\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                        <!-- 配套 end -->\n" + 
				"            <!-- 图片 start -->\n" + 
				"                        <div class=\"general-item general-tupian\" id='generalType'>\n" + 
				"                <h3><em></em>图片</h3>\n" + 
				"                <div class=\"general-item-wrap\">\n" + 
				"                    <ul class='general-pic-list'>\n" + 
				"                                                <li data-index=1>\n" + 
				"                            <img src=\"https://pic8.58cdn.com.cn/mobile/big/n_v2bfb7c82997df41a9b29a97e4987de304.jpg\">\n" + 
				"                        </li>\n" + 
				"                                            </ul>\n" + 
				"                    <div class=\"general_max_pic_button\" onclick=\"clickLog('from=fcpc_shangpu_detail_allpic')\">查看全部图片(1张)<i class=\"down\"></i></div>\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                        <!-- 图片 end -->\n" + 
				"\n" + 
				"            <!-- 楼盘 start -->\n" + 
				"            <div class=\"general-item general-loupan\" id='loupanWrap'>\n" + 
				"                <h3><em></em>楼盘<a href=\"\" class=\"loupan-detail-link\" onclick=\"clickLog('from=fcpc_shangpu_detail_loupan_click')\" target=\"_blank\">查看楼盘详情></a></h3>\n" + 
				"                <ul class=\"general-item-wrap\" id=\"loupan-info\"></ul>\n" + 
				"            </div>\n" + 
				"            <!-- 楼盘 end -->\n" + 
				"\n" + 
				"            <!-- 位置（商铺埋点） start -->\n" + 
				"                            <div class=\"general-item general-weizhi\" id='mapWrap'>\n" + 
				"                    <h3><em></em>位置</h3>\n" + 
				"                    <p class=\"addr\">地址：缙云区- 仙都国家级风景名胜区</p>\n" + 
				"                    <div id=\"general-item-wrap-ts\"></div>\n" + 
				"                    <div class=\"mapTab\" style=\"right:8px; top: 104px\">\n" + 
				"                        <ul id=\"mapItemBar\">\n" + 
				"                            <li class=\"active\">交通</li>\n" + 
				"                            <li>餐厅</li>\n" + 
				"                            <li>银行</li>\n" + 
				"                            <li>酒店</li>\n" + 
				"                        </ul>\n" + 
				"                        <ul class=\"tabbar\" id='tabbar'>\n" + 
				"                            <li class=\"active\">地铁</li>\n" + 
				"                            <li>公交</li>\n" + 
				"                        </ul>\n" + 
				"                        <ul id=\"mapResultBox\"></ul>\n" + 
				"                    </div>\n" + 
				"                </div>\n" + 
				"                        <!-- 位置（商铺埋点） end -->\n" + 
				"            <!-- 问答 start -->\n" + 
				"\n" + 
				"                        <div class=\"general-item general-question\" id='questionWrap'>\n" + 
				"                <h3><em></em>楼盘问答</h3>\n" + 
				"                <div class=\"question-wrap\">\n" + 
				"\n" + 
				"                    <ul class=\"question-list\">\n" + 
				"                                                <li class=\"\" onclick=\"window.clickLog('from=fcpc_shangpu_detail_wenda@position=1')\">\n" + 
				"                            <a href=\"https://www.58.com/wenda/dr907428026.shtml\">\n" + 
				"                                <dl class=\"question-title clearfix\">\n" + 
				"                                    <dt><span>提问</span></dt>\n" + 
				"                                    <dd class=\"question-text\">我决定在丽水开店做家居用品投资50~~100万元请问谁可以给我做个推荐呢？</dd>\n" + 
				"                                    <dd class=\"question-time\">2020-05-20</dd>\n" + 
				"                                </dl>\n" + 
				"                                                                <dl class=\"question-answer clearfix\">\n" + 
				"                                    <dd><span class=\"answer-name\">Loveme_qq03：</span>河南合力电气设备有限公司合力电气设备招商加盟</dd>\n" + 
				"                                </dl>\n" + 
				"                                                            </a>\n" + 
				"                        </li>\n" + 
				"                                                <li class=\"\" onclick=\"window.clickLog('from=fcpc_shangpu_detail_wenda@position=2')\">\n" + 
				"                            <a href=\"https://www.58.com/wenda/dr907255726.shtml\">\n" + 
				"                                <dl class=\"question-title clearfix\">\n" + 
				"                                    <dt><span>提问</span></dt>\n" + 
				"                                    <dd class=\"question-text\">丽水家具商场有哪些？</dd>\n" + 
				"                                    <dd class=\"question-time\">2020-05-13</dd>\n" + 
				"                                </dl>\n" + 
				"                                                                <dl class=\"question-answer clearfix\">\n" + 
				"                                    <dd><span class=\"answer-name\">ijxafy4586_EM656：</span>丽水家具商场有:\n" + 
				"1：红黄蓝家具公司\n" + 
				"地址：丽水市庆元县松源街15号\n" + 
				"公交路线：361路、960路、977路、959路、143路、229路\n" + 
				"2：丽水叶氏家具有限公司\n" + 
				"地址：丽水市水阁工业区平谷三路9号\n" + 
				"公交:113路、154路、56路、99路专线、876路</dd>\n" + 
				"                                </dl>\n" + 
				"                                                            </a>\n" + 
				"                        </li>\n" + 
				"                                                <li class=\"\" onclick=\"window.clickLog('from=fcpc_shangpu_detail_wenda@position=3')\">\n" + 
				"                            <a href=\"https://www.58.com/wenda/dr906204635.shtml\">\n" + 
				"                                <dl class=\"question-title clearfix\">\n" + 
				"                                    <dt><span>提问</span></dt>\n" + 
				"                                    <dd class=\"question-text\">【丽水莲都】莲都区100㎡百货超市生意转让，经营中1万元转让费</dd>\n" + 
				"                                    <dd class=\"question-time\">2020-03-29</dd>\n" + 
				"                                </dl>\n" + 
				"                                                            </a>\n" + 
				"                        </li>\n" + 
				"                                            </ul>\n" + 
				"                                    </div>\n" + 
				"            </div>\n" + 
				"                        <!-- 问答 end -->\n" + 
				"            <!-- 猜你喜欢 start -->\n" + 
				"            <div class=\"general-item general-guess\" id=\"guessLikeBottom\"></div>\n" + 
				"            <!-- 猜你喜欢 end -->\n" + 
				"            <div class=\"bottom-google-ad\">\n" + 
				"                <div id=\"googlead_list\"></div>\n" + 
				"            </div>\n" + 
				"            <!-- 吸顶导航条 start -->\n" + 
				"            <div class=\"house-float-nav\" id='floatNav'>\n" + 
				"                                <ul class='float-nav-list'>\n" + 
				"                    <li jumpto=\"intro\" onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=4@location=2')\">概况</li>\n" + 
				"                    <li jumpto='generalSound' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=2@location=2')\">描述</li>\n" + 
				"                                        <li jumpto='peitao' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=1@location=2')\">配套</li>\n" + 
				"                                                            <li jumpto='generalType' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=3@location=2')\">图片</li>\n" + 
				"                                        <li class=\"loupan-nav\" jumpto=\"loupanWrap\" onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=4@location=2')\">楼盘</li>\n" + 
				"                                            <li jumpto='mapWrap' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=5@location=2')\">位置</li>\n" + 
				"                                                            <li jumpto='questionWrap' onclick=\"clickLog('from=fcpc_shangpu_detail_TAB@name=6@location=2')\">楼盘问答</li>\n" + 
				"                                                        </ul>\n" + 
				"            </div>\n" + 
				"            <!-- 吸顶导航条  end -->\n" + 
				"            <!-- 大图模式 start -->\n" + 
				"                            <div class=\"piclayer\"></div>\n" + 
				"                <div class=\"picmask\">\n" + 
				"                    <div class=\"big-top-bigpic pr \">\n" + 
				"                        <img id=\"mainPic\" src=\" \">\n" + 
				"                        <div class=\"big-pic-load\" id=\"loadingBig \">\n" + 
				"                            <div class=\"top icon\"></div>\n" + 
				"                            <div class=\"bottom icon\"></div>\n" + 
				"                        </div>\n" + 
				"                    </div>\n" + 
				"                    <div class=\"big-pic-list pr\" style='display:none'>\n" + 
				"                        <ul id=\"smallPic\" class=\"bigpic-list-wrap pa \">\n" + 
				"                                                <li id=\"tu_2\" class=\"actives\" data-value=\"https://pic8.58cdn.com.cn/mobile/big/n_v2bfb7c82997df41a9b29a97e4987de304.jpg\">\n" + 
				"                            <img src=\"https://pic8.58cdn.com.cn/mobile/big/n_v2bfb7c82997df41a9b29a97e4987de304.jpg\">\n" + 
				"                        </li>\n" + 
				"                                                </ul>\n" + 
				"                    </div>\n" + 
				"                    <a id=\"blbt\" class=\"big-pic-left pa \" href=\"javascript:void(0);\">\n" + 
				"                        <i class=\"icon \"></i>\n" + 
				"                    </a>\n" + 
				"                    <a id=\"brbt\" class=\"big-pic-right pa\" href=\"javascript:void(0);\">\n" + 
				"                        <i class=\"icon \"></i>\n" + 
				"                    </a>\n" + 
				"                    <div class=\"picclose icon\"></div>\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"</div>\n" + 
				"<!-- 热门搜索start-->\n" + 
				"<div class=\"other-series-recommend\">\n" + 
				"    <ul class=\"other-series-nav f14 c_888 \" id=\"rec-bottom-nav\">\n" + 
				"                <li data-key=\"0 \" class=\"on \">推荐页面</li>\n" + 
				"                            <li data-key=\"1\">推荐区域页面</li>\n" + 
				"                                            <li data-key=\"4\">商圈商铺出租</li>\n" + 
				"            </ul>\n" + 
				"    <ul class=\"other-detail-introduce f12 c_888 \" id=\"rec-bottom-list\">\n" + 
				"                <li data-key=\"0 \" class=\"on \">\n" + 
				"                                    <a href=\"https://www.58.com/lishui/spcz-301/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水照相馆商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-302/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水打字复印店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-303/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水礼品饰品店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-304/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水饰品挂件店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-305/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水礼品店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-306/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水工艺品店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-307/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水礼品加工店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-308/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水珠宝玉器店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-309/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水音像书店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-310/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水百货店商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-311/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水桌球城商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-312/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水茶馆商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-313/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水水疗馆商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-314/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水麻将馆商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-315/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水歌舞厅商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-316/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水休闲中心商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-317/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水浴池浴场商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-318/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水桌游馆商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-319/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水溜冰场商铺出租</a>\n" + 
				"                        <a href=\"https://www.58.com/lishui/spcz-320/\" onclick=\"clickLog('from=fcpc_shangpu_detail_tuijianci')\"\n" + 
				"               target=\"_blank \">丽水电玩城商铺出租</a>\n" + 
				"                    </li>\n" + 
				"                            <li data-key=\"1\">\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-301/\"\n" + 
				"                target=\"_blank\">缙云照相馆商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-302/\"\n" + 
				"                target=\"_blank\">缙云打字复印店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-303/\"\n" + 
				"                target=\"_blank\">缙云礼品饰品店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-304/\"\n" + 
				"                target=\"_blank\">缙云饰品挂件店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-305/\"\n" + 
				"                target=\"_blank\">缙云礼品店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-306/\"\n" + 
				"                target=\"_blank\">缙云工艺品店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-307/\"\n" + 
				"                target=\"_blank\">缙云礼品加工店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-308/\"\n" + 
				"                target=\"_blank\">缙云珠宝玉器店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-309/\"\n" + 
				"                target=\"_blank\">缙云音像书店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-310/\"\n" + 
				"                target=\"_blank\">缙云百货店商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-311/\"\n" + 
				"                target=\"_blank\">缙云桌球城商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-312/\"\n" + 
				"                target=\"_blank\">缙云茶馆商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-313/\"\n" + 
				"                target=\"_blank\">缙云水疗馆商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-314/\"\n" + 
				"                target=\"_blank\">缙云麻将馆商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-315/\"\n" + 
				"                target=\"_blank\">缙云歌舞厅商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-316/\"\n" + 
				"                target=\"_blank\">缙云休闲中心商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-317/\"\n" + 
				"                target=\"_blank\">缙云浴池浴场商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-318/\"\n" + 
				"                target=\"_blank\">缙云桌游馆商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-319/\"\n" + 
				"                target=\"_blank\">缙云溜冰场商铺出租</a>\n" + 
				"                                <a href=\"https://www.58.com/jinyunqu/spcz-320/\"\n" + 
				"                target=\"_blank\">缙云电玩城商铺出租</a>\n" + 
				"                            </li>\n" + 
				"                                            <li data-key=\"4\">\n" + 
				"                                <a href=\"https://lishui.58.com/lianduqu/shangpucz/\"\n" + 
				"                target=\"_blank\">莲都商铺出租</a>\n" + 
				"                                <a href=\"https://lishui.58.com/jinyunqu/shangpucz/\"\n" + 
				"                target=\"_blank\">缙云商铺出租</a>\n" + 
				"                                <a href=\"https://lishui.58.com/qingtianqu/shangpucz/\"\n" + 
				"                target=\"_blank\">青田商铺出租</a>\n" + 
				"                                <a href=\"https://lishui.58.com/longquanqu/shangpucz/\"\n" + 
				"                target=\"_blank\">龙泉商铺出租</a>\n" + 
				"                                <a href=\"https://lishui.58.com/yunhequ/shangpucz/\"\n" + 
				"                target=\"_blank\">云和商铺出租</a>\n" + 
				"                                <a href=\"https://lishui.58.com/qingyuanquyu/shangpucz/\"\n" + 
				"                target=\"_blank\">庆元商铺出租</a>\n" + 
				"                                <a href=\"https://lishui.58.com/songyangqu/shangpucz/\"\n" + 
				"                target=\"_blank\">松阳商铺出租</a>\n" + 
				"                                <a href=\"https://lishui.58.com/suiyangqu/shangpucz/\"\n" + 
				"                target=\"_blank\">遂昌商铺出租</a>\n" + 
				"                                <a href=\"https://lishui.58.com/jingningqu/shangpucz/\"\n" + 
				"                target=\"_blank\">景宁商铺出租</a>\n" + 
				"                            </li>\n" + 
				"        \n" + 
				"    </ul>\n" + 
				"</div>\n" + 
				"\n" + 
				"<!--热门搜索end -->\n" + 
				"</div>\n" + 
				"<!--房源信息end-->\n" + 
				"\n" + 
				"<!-- 底部footer start -->\n" + 
				"<div id=\"footer\" class=\"footer\">\n" + 
				"    <div id=\"commonFooter\" class=\"commonFooter\"></div>\n" + 
				"</div>\n" + 
				"<!-- 底部footer end -->\n" + 
				"<!-- 其他人还在看 -->\n" + 
				"<!-- 埋点 -->\n" + 
				"<script src=\"//tracklog.58.com/referrer4.js\"></script>\n" + 
				"<!-- 引入fireWall -->\n" + 
				"<script type=\"text/javascript\">\n" + 
				"    window.commercial={\n" + 
				"        'common':{\n" + 
				"            source:101010010,\n" + 
				"            pagetype:0,\n" + 
				"            commonType:9,\n" + 
				"            platform:-1,\n" + 
				"        },\n" + 
				"        entityidlist: \"41672676882832\",\n" + 
				"        entityidtype:0,\n" + 
				"    }\n" + 
				"    window.xxfwConfig = {namespace: 'fangchan_business_pc'};\n" + 
				"\n" + 
				"    window.asyncJsList = window.asyncJsList || [];  \n" + 
				"    // window.asyncJsList.push({ url: \"//adshow.58.com/js/ssp_init.js\" });\n" + 
				"    window.asyncJsList.push({ url: \"//j1.58cdn.com.cn/crop/ecom/m/tcb/ideaShow/main_v20180917142647.js\" });\n" + 
				"    window.asyncJsList.push({ url: \"//track.58.com/adsys/postpageads?rand=\" });\n" + 
				"    window.asyncJsList.push({ url: \"//j1.58cdn.com.cn/crop/biz/pc/entrance/commercial_peg_v20191017170251.js\" });\n" + 
				"    window.asyncJsList.push({ url: \"//j1.58cdn.com.cn/resource/xxzl/xxfw/xxfw.min.js\" });\n" + 
				"</script>\n" + 
				"<!-- lego扣费js -->\n" + 
				"<script src=\"//j1.58cdn.com.cn/frs/fangfe/fang-lego-fee-sdk/1.0/bundle_v20190827173211.js\"></script>\n" + 
				"\n" + 
				"<script>\n" + 
				"    window.fromMess = 'spxqsidebar';\n" + 
				"    window.asyncJsList = window.asyncJsList || [];\n" + 
				"    // window.asyncJsList.push({ url: \"//stat-58house.58che.com/ol_58house.js\" }); //增加艾瑞代码\n" + 
				"    window.asyncJsList.push({ url: \"//j1.58cdn.com.cn/webim/js/entry_v20200515103852.js\" }); // 微聊代码\n" + 
				"    window.asyncJsList.push({ url: \"//j1.58cdn.com.cn/resource/xxzl/public/index.js\", callback: 'RightToolAddWX' }); //新版右侧底部返回顶部小挂件\n" + 
				"    window.wbAsyncInit = function wbAsyncInit(CL) {\n" + 
				"        CL.invoke('topbar', {\n" + 
				"            aroundCity: false,\n" + 
				"            weather: false,\n" + 
				"            appQR: true, // homepage QR\n" + 
				"            homepageLink: true,\n" + 
				"            size: 'default' // default: 1190px, narrow: 1000px\n" + 
				"        });\n" + 
				"        CL.invoke('footer');\n" + 
				"        /**\n" + 
				"         * 统一收藏弹窗 顶部 + 右侧\n" + 
				"         */\n" + 
				"        CL.invoke('popcollection', {\n" + 
				"            clickBtn: $('.clt-btn'),\n" + 
				"            source: \"passport\",\n" + 
				"            infoid: \"41672676882832\",\n" + 
				"            callback: function () {\n" + 
				"                $('.clt-btn').collectHouse();\n" + 
				"            }\n" + 
				"        });\n" + 
				"    };\n" + 
				"</script>\n" + 
				"<script src=\"//j1.58cdn.com.cn/frs/fangfe/pc-site-ts/1.11/business-detail-sp/main_v20200520142402.js\"></script>\n" + 
				"</body>\n" + 
				"</html>\n" + 
				"";
		
//		TransInfo ti = new TransInfo();
//		String id = url.split("=")[1];
//	      ti.setId(Integer.parseInt(id));
		
		Document doc = Jsoup.parse(s);
		String titleInfo = doc.title();
		if(titleInfo.indexOf("验证码") < 0) {
			//主板面
			Element main = doc.getElementsByClass("main-wrap").get(0);
			//头部信息
			Element first = main.getElementsByClass("house-title").get(0);
			//
			Elements markList = first.getElementsByTag("span");
			String marks = "";
	        for(Element mark : markList) {
	          String info = mark.attr("class");
	          if(!info.equals("up")) {
	            marks = marks + ":" + mark.text();
	          }else {
	            info = mark.text();
	            if(info.indexOf("更新于") >=0 ) {
//	              ti.setDate(info.replace("更新于", ""));
	            }else {
	              break;
	            }
	          }
	        }
//	        ti.setMarkinfo(marks);
	        
	        Element second = main.getElementsByClass("house-basic-right").get(0);
	        Elements infos = second.getElementsByClass("house_basic_title_info_2").get(0).children();
	        
	        String zone = infos.get(0).text();
	        String address =  infos.get(1).text();
	        String nick = second.getElementsByClass("poster-name").text();
	        String property = second.getElementsByClass("house_basic_title_info").get(0)
		        				.getElementsByTag("span").get(1).text();
//	        ti.setZone(zone);
//	        ti.setAddress(address);
//	        ti.setNick(nick);
//	        ti.setProperty(property);
	        
	      //详情
	        Element third = main.getElementsByClass("house-detail-left").get(0);
	        
	        Elements items = third.getElementById("intro").getElementsByTag("li");
	        for(Element item : items) {
	          String title = item.getElementsByClass("title").text();
	          String context = item.getElementsByClass("content").text();		  
	          
//	          switch (title) {
//	            case "月租": ti.setRent(context);break;
//	            case "转让费": ti.setTrans(context);break;
//	            case "押付": ti.setPayType(context);break;
//	            case "剩余租期": ti.setLastTerm(context);break;
//	            case "建筑面积": ti.setArea(context);break;
//	            case "商铺性质": ti.setShopProperty(context);break;
//	            case "商铺类型": ti.setShopType(context);break;
//	            case "经营状态": ti.setShopStatus(context);break;
//	            case "经营类型": ti.setShopRunType(context);break;
//	            case "楼层": ti.setFloors(context);break;
//	            case "规格": ti.setRegular(context);break;
//	            case "客流人群": ti.setCustomer(context);break;
//	            case "相关费用": ti.setFee(context);break;
//	            default:
//	              break;
//	          }
	        }
	        
	        
	        //正文处理
	        Element describe = third.getElementById("generalSound");
	        String context = describe.text();
	        
	        String bs = describe.getElementsByTag("p").get(0).text();
	        context = context.replace(bs, "");
//	        ti.setContext(context);
	        
	      //配套处理
	        Elements peitao = third.getElementById("peitao").getElementsByTag("li");
	        StringBuffer sb  = new StringBuffer();
	        for(Element pt :peitao) {
	          String className = pt.attr("class");
	          if(className.equals("peitao-on")) { //有配套
	            sb.append("|1");
	          }else{//无配套
	            sb.append("|0");
	          }
	        }
//	        String pt = sb.toString();
//	        if(pt.length() > 0) {
//	          pt = pt.substring(1, pt.length());
//	          ti.setPt(pt);
//	        }
	        
//	        //业务类型
//	        ti.setType(TransInfo.TYPE_58);
//	        ti.setDetailTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
	        
	        //图片处理 -> //https://pic8.58cdn.com.cn/mobile/big/n_v24c5d20ed8823497c8edc697e8e0e6d79.jpg
	        String pics = "";
	        
	        Elements pictures = third.getElementById("peitao").getElementsByTag("img");
	        for(Element pic : pictures) {
	          String originUrl = pic.attr("src"); //源地址
	          System.out.println(originUrl);
	          String imageName = originUrl.substring(originUrl.lastIndexOf("/") ,originUrl.length());
//	          download(originUrl,imageName); //下载
	          pics = pics + ";" + qiniuCrawlerPath + imageName ; //存到数据库
	        }
//	        if(pics.length() > 0) {
//	          ti.setLocalImages(pics.substring(1,pics.length()));
//	        }
	        
	        System.out.println(zone);
	        System.out.println(address);
	        System.out.println(nick);
	        System.out.println(property);
	        System.out.println(context);
	        System.out.println(sb.toString());
	        System.out.println(pics);
		}
		
	}

}
