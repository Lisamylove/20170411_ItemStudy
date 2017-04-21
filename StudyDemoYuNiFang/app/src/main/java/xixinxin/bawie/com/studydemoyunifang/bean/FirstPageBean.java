package xixinxin.bawie.com.studydemoyunifang.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/13 11:30
 */
public class FirstPageBean implements Serializable{

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{

        private ActivityInfoBean activityInfo;
        private boolean creditRecived;
        private List<SubjectsBean> subjects;
        private List<BestSellersBean> bestSellers;
        private List<Ad1Bean> ad1;
        private List<Ad5Bean> ad5;
        private List<DefaultGoodsListBean> defaultGoodsList;

        public ActivityInfoBean getActivityInfo() {
            return activityInfo;
        }

        public void setActivityInfo(ActivityInfoBean activityInfo) {
            this.activityInfo = activityInfo;
        }

        public boolean isCreditRecived() {
            return creditRecived;
        }

        public void setCreditRecived(boolean creditRecived) {
            this.creditRecived = creditRecived;
        }

        public List<SubjectsBean> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<SubjectsBean> subjects) {
            this.subjects = subjects;
        }

        public List<BestSellersBean> getBestSellers() {
            return bestSellers;
        }

        public void setBestSellers(List<BestSellersBean> bestSellers) {
            this.bestSellers = bestSellers;
        }

        public List<Ad1Bean> getAd1() {
            return ad1;
        }

        public void setAd1(List<Ad1Bean> ad1) {
            this.ad1 = ad1;
        }

        public List<Ad5Bean> getAd5() {
            return ad5;
        }

        public void setAd5(List<Ad5Bean> ad5) {
            this.ad5 = ad5;
        }

        public List<DefaultGoodsListBean> getDefaultGoodsList() {
            return defaultGoodsList;
        }

        public void setDefaultGoodsList(List<DefaultGoodsListBean> defaultGoodsList) {
            this.defaultGoodsList = defaultGoodsList;
        }

        public static class ActivityInfoBean implements Serializable{
            /**
             * activityAreaDisplay : 1
             * activityInfoList : [{"id":"5","activityImg":"https://image.yunifang.com/yunifang/images/goods/temp/170411101587013831833824559.jpg","activityType":"9","activityData":"141","activityDataDetail":"141","startSeconds":"-264283","endSeconds":"167711","activityStatus":"2","activityAreaDisplay":"1","countDownEnable":"1","remark":"春季特惠三人团","starttime":"2017.04.11 10:00:05","endtime":"2017.04.16 10:00:00","sort":0},{"id":"21","activityImg":"http://image.hmeili.com/yunifang/images/goods/temp/1611141100711533046163493.jpg","activityType":"1","activityData":"http://h.yunifang.com/invite/invite.html?login_check=2","activityDataDetail":"http%3A%2F%2Fh.yunifang.com%2Finvite%2Finvite.html%3Flogin_check%3D2","activityAreaDisplay":"1","countDownEnable":"0","sort":0},{"id":"60","activityImg":"https://image.yunifang.com/yunifang/images/goods/temp/1704111123354546748822154.jpg","activityType":"60","activityData":"69","activityDataDetail":"69","activityAreaDisplay":"1","countDownEnable":"0","sort":0}]
             */

            private String activityAreaDisplay;
            private List<ActivityInfoListBean> activityInfoList;

            public String getActivityAreaDisplay() {
                return activityAreaDisplay;
            }

            public void setActivityAreaDisplay(String activityAreaDisplay) {
                this.activityAreaDisplay = activityAreaDisplay;
            }

            public List<ActivityInfoListBean> getActivityInfoList() {
                return activityInfoList;
            }

            public void setActivityInfoList(List<ActivityInfoListBean> activityInfoList) {
                this.activityInfoList = activityInfoList;
            }

            public static class ActivityInfoListBean implements Serializable{
                /**
                 * id : 5
                 * activityImg : https://image.yunifang.com/yunifang/images/goods/temp/170411101587013831833824559.jpg
                 * activityType : 9
                 * activityData : 141
                 * activityDataDetail : 141
                 * startSeconds : -264283
                 * endSeconds : 167711
                 * activityStatus : 2
                 * activityAreaDisplay : 1
                 * countDownEnable : 1
                 * remark : 春季特惠三人团
                 * starttime : 2017.04.11 10:00:05
                 * endtime : 2017.04.16 10:00:00
                 * sort : 0
                 */

                private String id;
                private String activityImg;
                private String activityType;
                private String activityData;
                private String activityDataDetail;
                private String startSeconds;
                private String endSeconds;
                private String activityStatus;
                private String activityAreaDisplay;
                private String countDownEnable;
                private String remark;
                private String starttime;
                private String endtime;
                private int sort;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getActivityImg() {
                    return activityImg;
                }

                public void setActivityImg(String activityImg) {
                    this.activityImg = activityImg;
                }

                public String getActivityType() {
                    return activityType;
                }

                public void setActivityType(String activityType) {
                    this.activityType = activityType;
                }

                public String getActivityData() {
                    return activityData;
                }

                public void setActivityData(String activityData) {
                    this.activityData = activityData;
                }

                public String getActivityDataDetail() {
                    return activityDataDetail;
                }

                public void setActivityDataDetail(String activityDataDetail) {
                    this.activityDataDetail = activityDataDetail;
                }

                public String getStartSeconds() {
                    return startSeconds;
                }

                public void setStartSeconds(String startSeconds) {
                    this.startSeconds = startSeconds;
                }

                public String getEndSeconds() {
                    return endSeconds;
                }

                public void setEndSeconds(String endSeconds) {
                    this.endSeconds = endSeconds;
                }

                public String getActivityStatus() {
                    return activityStatus;
                }

                public void setActivityStatus(String activityStatus) {
                    this.activityStatus = activityStatus;
                }

                public String getActivityAreaDisplay() {
                    return activityAreaDisplay;
                }

                public void setActivityAreaDisplay(String activityAreaDisplay) {
                    this.activityAreaDisplay = activityAreaDisplay;
                }

                public String getCountDownEnable() {
                    return countDownEnable;
                }

                public void setCountDownEnable(String countDownEnable) {
                    this.countDownEnable = countDownEnable;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getStarttime() {
                    return starttime;
                }

                public void setStarttime(String starttime) {
                    this.starttime = starttime;
                }

                public String getEndtime() {
                    return endtime;
                }

                public void setEndtime(String endtime) {
                    this.endtime = endtime;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }
            }
        }

        public static class SubjectsBean implements Serializable{
            /**
             * id : 57
             * title : 新品尝鲜
             * detail : 春风十里 焕新不停歇
             每一次上新 都是一次相遇
             但我更希望 能在护肤的路上与你牵手同行
             了解你的喜怒哀乐与点点滴滴
             陪在你身边 用美好好宠爱你
             然后一起沐浴四月的春光养新肌
             * image : https://image.yunifang.com/yunifang/images/goods/temp/170411091549813066877768449.jpg
             * start_time : 2017.04.11 09:26:45
             * end_time : 2017.04.17 09:26:47
             * show_number : 6
             * state : 1
             * sort : 0
             * goodsList : [{"id":"1638","goods_name":"新品特惠加赠丨嫩肌酵素黑膜礼盒21片","shop_price":99.9,"market_price":299,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1638/goods_img/1704110948871376081418745.jpg","reservable":false,"efficacy":"鲜果酵素 弹嫩水润","stock_number":0,"restrict_purchase_num":0},{"id":"1615","goods_name":"新品眼罩丨悠然舒缓蒸汽眼罩","shop_price":49,"market_price":49,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1615/goods_img/17021711575612130589207037.jpg","reservable":false,"efficacy":"舒缓疲劳 莹亮眼周","stock_number":0,"restrict_purchase_num":0},{"id":"1280","goods_name":"新品上市|御泥坊精华水分光感气垫BB霜","shop_price":129,"market_price":169,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1280/goods_img/16120518307098199689667991.jpg","reservable":false,"efficacy":"控油遮瑕 水润透亮","stock_number":0,"restrict_purchase_num":0},{"id":"1281","goods_name":"新品眼霜丨红石榴矿物眼霜","shop_price":129,"market_price":159,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1281/goods_img/17030611054128553621233557.jpg","reservable":false,"efficacy":"亮肤修护 改善补水","stock_number":0,"restrict_purchase_num":0},{"id":"1250","goods_name":"新品面霜|红石榴矿物面霜50g","shop_price":55,"market_price":99,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1250/goods_img/170411101894511476806589724.jpg","reservable":false,"efficacy":"水润亮颜 紧致淡纹","stock_number":0,"restrict_purchase_num":0},{"id":"1247","goods_name":"新品面膜丨御泥坊海洋水漾透润面膜14片","shop_price":69.9,"market_price":198,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1247/goods_img/16112521579806692266373927.jpg","reservable":false,"efficacy":"冰川水能量 4D保湿","stock_number":0,"restrict_purchase_num":0},{"id":"1258","goods_name":"新品水果面膜|牛油果水润亲肤黑面膜7片","shop_price":49.9,"market_price":99,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1258/goods_img/16112810259763472659996926.jpg","reservable":false,"efficacy":"补水保湿 清洁净透","stock_number":0,"restrict_purchase_num":0},{"id":"1254","goods_name":"新品推荐|黑珍珠盈润亮采黑面膜7片","shop_price":49.9,"market_price":99,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1254/goods_img/16112517549399376533709198.jpg","reservable":false,"efficacy":"清洁补水 提亮肤色","stock_number":0,"restrict_purchase_num":0},{"id":"1255","goods_name":"新品黑膜丨黑糖清透净颜黑面膜7片","shop_price":79,"market_price":99,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1255/goods_img/161128093694015616375344334.jpg","reservable":false,"efficacy":"补水保湿 清洁净透","stock_number":0,"restrict_purchase_num":0},{"id":"1257","goods_name":"新品面膜丨瑞士欧锦葵深补水修护面膜5片","shop_price":59.9,"market_price":79,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1257/goods_img/16112810218779610552336670.jpg","reservable":false,"efficacy":"深层补水 舒缓修护","stock_number":0,"restrict_purchase_num":0},{"id":"1256","goods_name":"新品面膜丨埃及洛神花紧致面膜5片 3段式提拉","shop_price":59.9,"market_price":79,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1256/goods_img/161128101656810774865882474.jpg","reservable":false,"efficacy":"润泽修护 提拉紧致","stock_number":0,"restrict_purchase_num":0},{"id":"1221","goods_name":"男士新品丨炫活亮肤礼盒","shop_price":139.9,"market_price":237,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1221/goods_img/161120132834212433896505066.jpg","reservable":false,"efficacy":"炫活亮彩 劲能醒肤","stock_number":0,"restrict_purchase_num":0},{"id":"1176","goods_name":"新品上市丨男士火山泥清洁控油洁面乳2支装","shop_price":39.9,"market_price":89,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1176/goods_img/16111400198611202108006896.jpg","reservable":false,"efficacy":"深层清洁 平衡水油","stock_number":0,"restrict_purchase_num":0},{"id":"1699","goods_name":"男士新品丨玉石紧致细肤水凝面膜","shop_price":99.9,"market_price":159,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1699/goods_img/170314092523919884876852385.jpg","reservable":false,"efficacy":"紧致细肤 平抚肌纹","stock_number":0,"restrict_purchase_num":0},{"id":"1698","goods_name":"男士新品丨碧玺滋养修护水凝面膜","shop_price":99.9,"market_price":159,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1698/goods_img/17031409161239002438572691.jpg","reservable":false,"efficacy":"滋养修护 提升活力","stock_number":0,"restrict_purchase_num":0}]
             * goodsIdsList : ["1638","1615","1280","1281","1250","1247","1258","1254","1255","1257","1256","1221","1176","1699","1698"]
             */

            private String id;
            private String title;
            private String detail;
            private String image;
            private String start_time;
            private String end_time;
            private int show_number;
            private String state;
            private int sort;
            private List<GoodsListBean> goodsList;
            private List<String> goodsIdsList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public int getShow_number() {
                return show_number;
            }

            public void setShow_number(int show_number) {
                this.show_number = show_number;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public List<GoodsListBean> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<GoodsListBean> goodsList) {
                this.goodsList = goodsList;
            }

            public List<String> getGoodsIdsList() {
                return goodsIdsList;
            }

            public void setGoodsIdsList(List<String> goodsIdsList) {
                this.goodsIdsList = goodsIdsList;
            }

            public static class GoodsListBean implements Serializable{
                /**
                 * id : 1638
                 * goods_name : 新品特惠加赠丨嫩肌酵素黑膜礼盒21片
                 * shop_price : 99.9
                 * market_price : 299.0
                 * goods_img : https://image.yunifang.com/yunifang/images/goods/1638/goods_img/1704110948871376081418745.jpg
                 * reservable : false
                 * efficacy : 鲜果酵素 弹嫩水润
                 * stock_number : 0
                 * restrict_purchase_num : 0
                 */

                private String id;
                private String goods_name;
                private double shop_price;
                private double market_price;
                private String goods_img;
                private boolean reservable;
                private String efficacy;
                private int stock_number;
                private int restrict_purchase_num;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public double getShop_price() {
                    return shop_price;
                }

                public void setShop_price(double shop_price) {
                    this.shop_price = shop_price;
                }

                public double getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(double market_price) {
                    this.market_price = market_price;
                }

                public String getGoods_img() {
                    return goods_img;
                }

                public void setGoods_img(String goods_img) {
                    this.goods_img = goods_img;
                }

                public boolean isReservable() {
                    return reservable;
                }

                public void setReservable(boolean reservable) {
                    this.reservable = reservable;
                }

                public String getEfficacy() {
                    return efficacy;
                }

                public void setEfficacy(String efficacy) {
                    this.efficacy = efficacy;
                }

                public int getStock_number() {
                    return stock_number;
                }

                public void setStock_number(int stock_number) {
                    this.stock_number = stock_number;
                }

                public int getRestrict_purchase_num() {
                    return restrict_purchase_num;
                }

                public void setRestrict_purchase_num(int restrict_purchase_num) {
                    this.restrict_purchase_num = restrict_purchase_num;
                }
            }
        }

        public static class BestSellersBean implements Serializable{
            /**
             * id : 2
             * name : 春季热销
             * descript : 1
             * state : 1
             * show_number : 6
             * begin_date : 2017.02.15 09:56:58
             * end_date : 2017.06.15 10:00:00
             * goodsList : [{"id":"191","goods_name":"清洁补水保湿护肤三件套（满159立减20）","shop_price":139.9,"market_price":347,"goods_img":"http://image.hmeili.com/yunifang/images/goods/191/goods_img/16081909118566356917232988.jpg","reservable":false,"efficacy":"温和清洁 补水保湿","stock_number":0,"restrict_purchase_num":0},{"id":"5","goods_name":"黑眼圈不见啦丨金桂花矿物眼膜贴60片","shop_price":59,"market_price":89,"goods_img":"http://image.hmeili.com/yunifang/images/goods/5/goods_img/16081908444051052195086751.jpg","reservable":false,"efficacy":"补水靓眼 改善熊猫眼","stock_number":0,"restrict_purchase_num":0},{"id":"10","goods_name":"睡出白美人|美白嫩肤睡眠面膜180g","shop_price":59.9,"market_price":99,"goods_img":"http://image.hmeili.com/yunifang/images/goods/10/goods_img/161109200044614716799834077.jpg","reservable":false,"efficacy":"补水美白 越睡越白","stock_number":0,"restrict_purchase_num":0},{"id":"14","goods_name":"矿物泥浆鼻膜60g（限时加赠）","shop_price":55,"market_price":69,"goods_img":"https://image.yunifang.com/yunifang/images/goods/14/goods_img/17041109571765119064559612.jpg","reservable":false,"efficacy":"草莓鼻小救星 收敛毛孔","stock_number":0,"restrict_purchase_num":0},{"id":"1638","goods_name":"新品特惠加赠丨嫩肌酵素黑膜礼盒21片","shop_price":99.9,"market_price":299,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1638/goods_img/1704110948871376081418745.jpg","reservable":false,"efficacy":"鲜果酵素 弹嫩水润","stock_number":0,"restrict_purchase_num":0},{"id":"8","goods_name":"镇店之宝|美白嫩肤面膜20片","shop_price":119.9,"market_price":298,"goods_img":"https://image.yunifang.com/yunifang/images/goods/8/goods_img/1703060954389257968293129.jpg","reservable":false,"efficacy":"爆款面膜 明星同款","stock_number":0,"restrict_purchase_num":0},{"id":"6","goods_name":"好用不贵丨亮颜水润蚕丝面膜（寂地定制版）","shop_price":59.9,"market_price":239.9,"goods_img":"http://image.hmeili.com/yunifang/images/goods/6/goods_img/160819084594721181484473699.jpg","reservable":false,"efficacy":"深层补水 提亮肤色","stock_number":0,"restrict_purchase_num":0},{"id":"446","goods_name":"芦荟补水保湿凝胶150g","shop_price":39.9,"market_price":59,"goods_img":"http://image.hmeili.com/yunifang/images/goods/446/goods_img/16081909409518953549635059.jpg","reservable":false,"efficacy":"水水润润 修护受损","stock_number":0,"restrict_purchase_num":0},{"id":"14","goods_name":"矿物泥浆鼻膜60g（限时加赠）","shop_price":55,"market_price":69,"goods_img":"https://image.yunifang.com/yunifang/images/goods/14/goods_img/17041109571765119064559612.jpg","reservable":false,"efficacy":"草莓鼻小救星 收敛毛孔","stock_number":0,"restrict_purchase_num":0},{"id":"1189","goods_name":"清透水嫩亮颜黑面膜套装21片","shop_price":89.9,"market_price":297,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1189/goods_img/161128144382319687354892538.jpg","reservable":false,"efficacy":"净透补水 润泽提亮","stock_number":0,"restrict_purchase_num":0}]
             * goodsIdsList : ["191","5","10","14","1638","8","6","446","14","1189"]
             */

            private String id;
            private String name;
            private String descript;
            private String state;
            private int show_number;
            private String begin_date;
            private String end_date;
            private List<GoodsListBeanX> goodsList;
            private List<String> goodsIdsList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescript() {
                return descript;
            }

            public void setDescript(String descript) {
                this.descript = descript;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getShow_number() {
                return show_number;
            }

            public void setShow_number(int show_number) {
                this.show_number = show_number;
            }

            public String getBegin_date() {
                return begin_date;
            }

            public void setBegin_date(String begin_date) {
                this.begin_date = begin_date;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public List<GoodsListBeanX> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<GoodsListBeanX> goodsList) {
                this.goodsList = goodsList;
            }

            public List<String> getGoodsIdsList() {
                return goodsIdsList;
            }

            public void setGoodsIdsList(List<String> goodsIdsList) {
                this.goodsIdsList = goodsIdsList;
            }

            public static class GoodsListBeanX implements Serializable{
                /**
                 * id : 191
                 * goods_name : 清洁补水保湿护肤三件套（满159立减20）
                 * shop_price : 139.9
                 * market_price : 347.0
                 * goods_img : http://image.hmeili.com/yunifang/images/goods/191/goods_img/16081909118566356917232988.jpg
                 * reservable : false
                 * efficacy : 温和清洁 补水保湿
                 * stock_number : 0
                 * restrict_purchase_num : 0
                 */

                private String id;
                private String goods_name;
                private double shop_price;
                private double market_price;
                private String goods_img;
                private boolean reservable;
                private String efficacy;
                private int stock_number;
                private int restrict_purchase_num;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public double getShop_price() {
                    return shop_price;
                }

                public void setShop_price(double shop_price) {
                    this.shop_price = shop_price;
                }

                public double getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(double market_price) {
                    this.market_price = market_price;
                }

                public String getGoods_img() {
                    return goods_img;
                }

                public void setGoods_img(String goods_img) {
                    this.goods_img = goods_img;
                }

                public boolean isReservable() {
                    return reservable;
                }

                public void setReservable(boolean reservable) {
                    this.reservable = reservable;
                }

                public String getEfficacy() {
                    return efficacy;
                }

                public void setEfficacy(String efficacy) {
                    this.efficacy = efficacy;
                }

                public int getStock_number() {
                    return stock_number;
                }

                public void setStock_number(int stock_number) {
                    this.stock_number = stock_number;
                }

                public int getRestrict_purchase_num() {
                    return restrict_purchase_num;
                }

                public void setRestrict_purchase_num(int restrict_purchase_num) {
                    this.restrict_purchase_num = restrict_purchase_num;
                }
            }
        }

        public static class Ad1Bean implements Serializable{
            /**
             * id : 913
             * image : https://image.yunifang.com/yunifang/images/goods/ad0/17041011274991545565008078.jpg
             * ad_type : 0
             * sort : 1119
             * position : 0
             * enabled : 1
             * createtime : 2017.04.10 11:28:26
             * createuser : hani
             * ad_type_dynamic : 1
             * ad_type_dynamic_data : http://m.yunifang.com/yunifang/web/h/goods_intro_pre_new.html
             * ad_type_dynamic_detail : http%3A%2F%2Fm.yunifang.com%2Fyunifang%2Fweb%2Fh%2Fgoods_intro_pre_new.html
             * title : 沐浴春光养新肌-APP
             * channelType : 1
             * show_channel : 1,2,3,4
             * lastupdateuser : hani
             */

            private String id;
            private String image;
            private int ad_type;
            private int sort;
            private int position;
            private int enabled;
            private String createtime;
            private String createuser;
            private String ad_type_dynamic;
            private String ad_type_dynamic_data;
            private String ad_type_dynamic_detail;
            private String title;
            private String channelType;
            private String show_channel;
            private String lastupdateuser;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getAd_type() {
                return ad_type;
            }

            public void setAd_type(int ad_type) {
                this.ad_type = ad_type;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getCreateuser() {
                return createuser;
            }

            public void setCreateuser(String createuser) {
                this.createuser = createuser;
            }

            public String getAd_type_dynamic() {
                return ad_type_dynamic;
            }

            public void setAd_type_dynamic(String ad_type_dynamic) {
                this.ad_type_dynamic = ad_type_dynamic;
            }

            public String getAd_type_dynamic_data() {
                return ad_type_dynamic_data;
            }

            public void setAd_type_dynamic_data(String ad_type_dynamic_data) {
                this.ad_type_dynamic_data = ad_type_dynamic_data;
            }

            public String getAd_type_dynamic_detail() {
                return ad_type_dynamic_detail;
            }

            public void setAd_type_dynamic_detail(String ad_type_dynamic_detail) {
                this.ad_type_dynamic_detail = ad_type_dynamic_detail;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getChannelType() {
                return channelType;
            }

            public void setChannelType(String channelType) {
                this.channelType = channelType;
            }

            public String getShow_channel() {
                return show_channel;
            }

            public void setShow_channel(String show_channel) {
                this.show_channel = show_channel;
            }

            public String getLastupdateuser() {
                return lastupdateuser;
            }

            public void setLastupdateuser(String lastupdateuser) {
                this.lastupdateuser = lastupdateuser;
            }
        }

        public static class Ad5Bean implements Serializable{
            /**
             * id : 359
             * image : http://image.hmeili.com/yunifang/images/goods/ad0/160823172997710201253418883.png
             * ad_type : 4
             * sort : 106
             * position : 5
             * enabled : 0
             * ad_type_dynamic : 1
             * ad_type_dynamic_data : http://h.yunifang.com/sign/sign.html?login_check=2
             * ad_type_dynamic_detail : http%3A%2F%2Fh.yunifang.com%2Fsign%2Fsign.html%3Flogin_check%3D2
             * show_channel : 1,2
             * title : 每日签到
             * url : http://mobile.hmeili.com/yunifang/web/member/gift
             */

            private String id;
            private String image;
            private int ad_type;
            private int sort;
            private int position;
            private int enabled;
            private String ad_type_dynamic;
            private String ad_type_dynamic_data;
            private String ad_type_dynamic_detail;
            private String show_channel;
            private String title;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getAd_type() {
                return ad_type;
            }

            public void setAd_type(int ad_type) {
                this.ad_type = ad_type;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public String getAd_type_dynamic() {
                return ad_type_dynamic;
            }

            public void setAd_type_dynamic(String ad_type_dynamic) {
                this.ad_type_dynamic = ad_type_dynamic;
            }

            public String getAd_type_dynamic_data() {
                return ad_type_dynamic_data;
            }

            public void setAd_type_dynamic_data(String ad_type_dynamic_data) {
                this.ad_type_dynamic_data = ad_type_dynamic_data;
            }

            public String getAd_type_dynamic_detail() {
                return ad_type_dynamic_detail;
            }

            public void setAd_type_dynamic_detail(String ad_type_dynamic_detail) {
                this.ad_type_dynamic_detail = ad_type_dynamic_detail;
            }

            public String getShow_channel() {
                return show_channel;
            }

            public void setShow_channel(String show_channel) {
                this.show_channel = show_channel;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class DefaultGoodsListBean implements Serializable{
            /**
             * id : 121
             * goods_name : 镇店之宝丨美白嫩肤面膜7片
             * shop_price : 49.9
             * market_price : 99.0
             * goods_img : https://image.yunifang.com/yunifang/images/goods/121/goods_img/170301091610311632161123479.jpg
             * reservable : false
             * efficacy : 镇店之宝 美白爆款
             * stock_number : 0
             * restrict_purchase_num : 0
             */

            private String id;
            private String goods_name;
            private double shop_price;
            private double market_price;
            private String goods_img;
            private boolean reservable;
            private String efficacy;
            private int stock_number;
            private int restrict_purchase_num;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public double getShop_price() {
                return shop_price;
            }

            public void setShop_price(double shop_price) {
                this.shop_price = shop_price;
            }

            public double getMarket_price() {
                return market_price;
            }

            public void setMarket_price(double market_price) {
                this.market_price = market_price;
            }

            public String getGoods_img() {
                return goods_img;
            }

            public void setGoods_img(String goods_img) {
                this.goods_img = goods_img;
            }

            public boolean isReservable() {
                return reservable;
            }

            public void setReservable(boolean reservable) {
                this.reservable = reservable;
            }

            public String getEfficacy() {
                return efficacy;
            }

            public void setEfficacy(String efficacy) {
                this.efficacy = efficacy;
            }

            public int getStock_number() {
                return stock_number;
            }

            public void setStock_number(int stock_number) {
                this.stock_number = stock_number;
            }

            public int getRestrict_purchase_num() {
                return restrict_purchase_num;
            }

            public void setRestrict_purchase_num(int restrict_purchase_num) {
                this.restrict_purchase_num = restrict_purchase_num;
            }
        }
    }
}
