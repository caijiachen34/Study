package com.example.administrator.mobileshop01.utils;


import java.util.List;

public class JsonResultGet {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"e7bf6b07d5deb68169a9bec5a5a59fa8","title":"想尽一切办法让iPhone12不延期，苹果居然这样做？","date":"2020-04-08 15:44","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408154418194.html","thumbnail_pic_s":"https://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_2_mwpm_03200403.jpg"},{"uniquekey":"2d48edd6706e5e0b6b8f513af0e5bf80","title":"全球新冠肺炎COVID-19实时追踪，关注全球疫情动态","date":"2020-04-08 15:49:37","category":"头条","author_name":"健康资讯","url":"https://covid-19.juheapi.com/?s=toutiao","thumbnail_pic_s":"https://juheimgs.oss-cn-beijing.aliyuncs.com/banner/202003/d8376e7e3010cc3f.png","thumbnail_pic_s02":"https://juheimgs.oss-cn-beijing.aliyuncs.com/banner/202003/d8376e7e3010cc3f.png","thumbnail_pic_s03":"https://juheimgs.oss-cn-beijing.aliyuncs.com/banner/202003/d8376e7e3010cc3f.png"},{"uniquekey":"6cb20e6f048fe2ca062ba2ebe9845f45","title":"一波直观预测！PS5 & PS4手柄大小/设计叠图对比","date":"2020-04-08 15:39","category":"科技","author_name":"游侠网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153937062.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153937_fb50cfdb03dae44c5d6dc00f38cceb0e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153937_fb50cfdb03dae44c5d6dc00f38cceb0e_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/20200408153937_fb50cfdb03dae44c5d6dc00f38cceb0e_3_mwpm_03200403.jpg"},{"uniquekey":"5280798aa3c46b2253f0579b414d2832","title":"手机厂商扎堆进军！华为或将发布65W氮化镓充电器","date":"2020-04-08 15:37","category":"科技","author_name":"爱集微","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153741015.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153741_d601df10d3763dbc392fc015e3815b92_1_mwpm_03200403.jpg"},{"uniquekey":"534bdcb759a407491f59e83a6b1ee3dc","title":"iPhone9 真的要来了？现已加入美国以旧换新套餐","date":"2020-04-08 15:36","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153607025.html","thumbnail_pic_s":"https://00imgmini.eastday.com/mobile/20200408/20200408153607_4069a0507e9b2f394469b3a0295b9536_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00imgmini.eastday.com/mobile/20200408/20200408153607_4069a0507e9b2f394469b3a0295b9536_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00imgmini.eastday.com/mobile/20200408/20200408153607_4069a0507e9b2f394469b3a0295b9536_1_mwpm_03200403.jpg"},{"uniquekey":"cbd6663288bb89366ec01ecf43851499","title":"原创 骁龙865+120Hz高刷屏 iQOO Neo3核心配置曝光 或预定性能排行榜首","date":"2020-04-08 15:35","category":"科技","author_name":"机智万象","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153549027.html","thumbnail_pic_s":"https://02imgmini.eastday.com/mobile/20200408/20200408153549_a22c7779a6a83749cd25183d7b70171c_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02imgmini.eastday.com/mobile/20200408/20200408153549_a22c7779a6a83749cd25183d7b70171c_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02imgmini.eastday.com/mobile/20200408/20200408153549_a22c7779a6a83749cd25183d7b70171c_5_mwpm_03200403.jpg"},{"uniquekey":"23b3ed19e5b883f371cbea09f9704dc2","title":"三星新机通过 WiFi 联盟认证，或将在近期发布","date":"2020-04-08 15:35","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153544889.html","thumbnail_pic_s":"https://03imgmini.eastday.com/mobile/20200408/20200408153544_4840c7750a551674cc174093daa446cd_1_mwpm_03200403.jpg"},{"uniquekey":"0643e0bf49de13bacb1a4ad13954c66c","title":"同价位罕有 3 倍光学变焦 荣耀 30S 同一场景如何发挥多摄优势？","date":"2020-04-08 15:35","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153540361.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153540_c4e13d9f6cad69ff255d2646edacde86_21_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153540_c4e13d9f6cad69ff255d2646edacde86_16_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/20200408153540_c4e13d9f6cad69ff255d2646edacde86_1_mwpm_03200403.jpg"},{"uniquekey":"3c90243787526d91ef6af17e15e888d5","title":"安兔兔三月跑分出炉，这款中端 SOC 蝉联冠军","date":"2020-04-08 15:35","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153530172.html","thumbnail_pic_s":"https://03imgmini.eastday.com/mobile/20200408/20200408153530_9f8e5bbfbfde583e7a4f0b5fd03ac695_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03imgmini.eastday.com/mobile/20200408/20200408153530_9f8e5bbfbfde583e7a4f0b5fd03ac695_2_mwpm_03200403.jpg"},{"uniquekey":"da7a32efc32b1db8a31b8e97eefaa5a9","title":"苹果公布自家防护面罩说明文档 每周将生产100万个","date":"2020-04-08 15:35","category":"科技","author_name":"天极网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153508153.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153508_310b299c5a3e663b1cfaddfe96a99fcc_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20200408/20200408153508_310b299c5a3e663b1cfaddfe96a99fcc_2_mwpm_03200403.jpg"},{"uniquekey":"7c1d385f050a0b7f617cd3c6ff3e4b76","title":"9.9元包邮和69元的黑科技，差价7倍你选哪个？飞智影刺上手体验","date":"2020-04-08 15:34","category":"科技","author_name":"定焦科技","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153448275.html","thumbnail_pic_s":"https://09imgmini.eastday.com/mobile/20200408/20200408153448_07e2cb6408f7f3422b6f9f7c87390908_22_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09imgmini.eastday.com/mobile/20200408/20200408153448_07e2cb6408f7f3422b6f9f7c87390908_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09imgmini.eastday.com/mobile/20200408/20200408153448_07e2cb6408f7f3422b6f9f7c87390908_20_mwpm_03200403.jpg"},{"uniquekey":"d2df50accc9e496f4f86cebda1793fb7","title":"三星 Note20 系列模具遭曝光，保留实体键采用相机矩阵","date":"2020-04-08 15:34","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153435550.html","thumbnail_pic_s":"https://01imgmini.eastday.com/mobile/20200408/20200408153435_e767a9bd60baee26084ce4e37f9c6876_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01imgmini.eastday.com/mobile/20200408/20200408153435_e767a9bd60baee26084ce4e37f9c6876_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01imgmini.eastday.com/mobile/20200408/20200408153435_e767a9bd60baee26084ce4e37f9c6876_2_mwpm_03200403.jpg"},{"uniquekey":"8e9653211a2e02df49f59ac7bfe7155e","title":"英伟达迎来强大竞争对手：华为计划今年打入 GPU 服务器市场","date":"2020-04-08 15:34","category":"科技","author_name":"天极网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153433271.html","thumbnail_pic_s":"https://09imgmini.eastday.com/mobile/20200408/20200408153433_f0d47e6c3a1a023bbb3bee48a82f6470_1_mwpm_03200403.jpg"},{"uniquekey":"b1c8c9c5e7d5b075c71a7047d720f904","title":"长亭科技推出重大活动网络安全保障解决方案","date":"2020-04-08 15:34","category":"科技","author_name":"砍柴网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153432529.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153432_2297b84c2581ea2b592c8d4db735ac9e_1_mwpm_03200403.jpg"},{"uniquekey":"7e9ff5f7516f2772be632dd9dcdb13b0","title":"英特尔Mozilla等企业宣布加入Open COVID Pledge技术开放联盟","date":"2020-04-08 15:34","category":"科技","author_name":"cnBeta","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153422094.html","thumbnail_pic_s":"https://00imgmini.eastday.com/mobile/20200408/20200408153422_87eddaae53bb21b2857bdd45a0372f33_1_mwpm_03200403.jpg"},{"uniquekey":"d773872827669a7d71b284afc2773f61","title":"将大像素进行到底，小米 CC10 Pro 将首发 1.92 亿像素","date":"2020-04-08 15:34","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153421864.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153421_09a0c0a1a88a0fb0af54ae509b7d020c_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153421_09a0c0a1a88a0fb0af54ae509b7d020c_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/20200408153421_09a0c0a1a88a0fb0af54ae509b7d020c_2_mwpm_03200403.jpg"},{"uniquekey":"f52a050448eaecdd91fb6b4deddbc7e9","title":"小米有品新品：4年续航，不用钥匙手机也能开锁","date":"2020-04-08 15:34","category":"科技","author_name":"吖有","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153419452.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/2020040815_dfc0e05e43e543edbb0b2dcbcbd54b31_6607_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/2020040815_2c9193c797704ee4ade9fa5da0ab2f2c_6469_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/2020040815_9dea5adf813c4b52bb165aba6c4e57a5_1359_cover_mwpm_03200403.jpg"},{"uniquekey":"3b379a8f3388350b7b3950bd450469a6","title":"多倍乐趣 多倍体验 三星 Galaxy S20 5G 系列才是当下真顶级旗舰","date":"2020-04-08 15:34","category":"科技","author_name":"砍柴网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153409087.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153409_8e3bd1990f852e17a0528241fee70fc0_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20200408/20200408153409_8e3bd1990f852e17a0528241fee70fc0_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07imgmini.eastday.com/mobile/20200408/20200408153409_8e3bd1990f852e17a0528241fee70fc0_3_mwpm_03200403.jpg"},{"uniquekey":"c330cbcd98fc5368f5240093dc643796","title":"苹果新专利曝光，喜欢躺着玩手机的人注意了！","date":"2020-04-08 15:34","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153402702.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153402_93388162f57943541b30d0cb42d4c6c8_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153402_93388162f57943541b30d0cb42d4c6c8_1_mwpm_03200403.jpg"},{"uniquekey":"36c7e0ee122fe61624999aa11da30a50","title":"Netflix将允许家长删除部分节目 为孩子筛选内容","date":"2020-04-08 15:34","category":"科技","author_name":"澎湃新闻网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153401887.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153401_191486406fa9255939e534ac363277a8_1_mwpm_03200403.jpg"},{"uniquekey":"f14d1b66852bdf40f18d88f24cc74e37","title":"王雪红：VR 给予人类突破局限，促使科技与人文结合","date":"2020-04-08 15:33","category":"科技","author_name":"砍柴网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153358791.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153358_af374772ead6de1efeebec871df9d257_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20200408/20200408153358_af374772ead6de1efeebec871df9d257_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07imgmini.eastday.com/mobile/20200408/20200408153358_af374772ead6de1efeebec871df9d257_5_mwpm_03200403.jpg"},{"uniquekey":"b2ec4b2711c2e0ddef3b332f8db41ea7","title":"国产生产商长脸了！黑鲨 3 Pro 搭载的京东方屏幕获好评","date":"2020-04-08 15:33","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153335701.html","thumbnail_pic_s":"https://03imgmini.eastday.com/mobile/20200408/20200408153335_e690e8e6d73f959e41b80ae13d3aa785_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03imgmini.eastday.com/mobile/20200408/20200408153335_e690e8e6d73f959e41b80ae13d3aa785_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03imgmini.eastday.com/mobile/20200408/20200408153335_e690e8e6d73f959e41b80ae13d3aa785_3_mwpm_03200403.jpg"},{"uniquekey":"772b6d6ae33491f5e6cd39d717493e1a","title":"苹果再次驰援\u201c小弟\u201d JDI，花 2 亿买了一批\u201c废铁\u201d","date":"2020-04-08 15:33","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153305940.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153305_f7d27461dc8f716050f1526f2f1ec789_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153305_f7d27461dc8f716050f1526f2f1ec789_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/20200408153305_f7d27461dc8f716050f1526f2f1ec789_3_mwpm_03200403.jpg"},{"uniquekey":"d8d7dae2a00901b572ccd0b670d0e708","title":"高分 APP 被苹果收购，安卓用户在 7 月 1 日后没法享用了","date":"2020-04-08 15:33","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153303642.html","thumbnail_pic_s":"https://01imgmini.eastday.com/mobile/20200408/20200408153303_4318ba40efec3613cfe78300cc41faff_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01imgmini.eastday.com/mobile/20200408/20200408153303_4318ba40efec3613cfe78300cc41faff_2_mwpm_03200403.jpg"},{"uniquekey":"c723cfa8d6bff889146a9f0af69bea63","title":"iPhone 9 再被曝光，或许能在 4 月 5 日之后发布？","date":"2020-04-08 15:32","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153250872.html","thumbnail_pic_s":"https://02imgmini.eastday.com/mobile/20200408/20200408153250_38b73b213a3ce76b300ed407ae8e800b_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02imgmini.eastday.com/mobile/20200408/20200408153250_38b73b213a3ce76b300ed407ae8e800b_2_mwpm_03200403.jpg"},{"uniquekey":"cae229a7f21790523f22e99d4722d92a","title":"vivo再发新机Y50，千元档主打性价比，却被吐槽产品线混乱","date":"2020-04-08 15:32","category":"科技","author_name":"科技视镜","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153238587.html","thumbnail_pic_s":"https://01imgmini.eastday.com/mobile/20200408/2020040815_aca6dc5a65274344888e035237f13889_7587_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01imgmini.eastday.com/mobile/20200408/2020040815_635ef86d807a4f51b6503a61be5fdac3_0323_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01imgmini.eastday.com/mobile/20200408/2020040815_eab0a63906d744608c04daedc827823f_1270_cover_mwpm_03200403.jpg"},{"uniquekey":"db4e5d571697315ac5a2493767503cd6","title":"666 元的 Redmi 新机？甚至还有 18W 快充","date":"2020-04-08 15:32","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153230987.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153230_75a8950275510af26a7008d6cdf40cab_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20200408/20200408153230_75a8950275510af26a7008d6cdf40cab_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07imgmini.eastday.com/mobile/20200408/20200408153230_75a8950275510af26a7008d6cdf40cab_3_mwpm_03200403.jpg"},{"uniquekey":"8cc0c6ab9cbb6ad0db72f28e98b2bd4c","title":"iPhone 9 多项参数配置曝光，续航将会猛增？","date":"2020-04-08 15:32","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153227562.html","thumbnail_pic_s":"https://02imgmini.eastday.com/mobile/20200408/20200408153227_c7fd04a9141eaef452a6a226e57fe6bd_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02imgmini.eastday.com/mobile/20200408/20200408153227_c7fd04a9141eaef452a6a226e57fe6bd_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02imgmini.eastday.com/mobile/20200408/20200408153227_c7fd04a9141eaef452a6a226e57fe6bd_2_mwpm_03200403.jpg"},{"uniquekey":"c5e90c61109ded239d33ee6b3a82d7fa","title":"千东商城：打通互联网公司、高净值用户和优质商品的桥梁","date":"2020-04-08 15:32","category":"科技","author_name":"美通社","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153203564.html","thumbnail_pic_s":"https://08imgmini.eastday.com/mobile/20200408/20200408153203_ff6a525197c7e5d6757576a31703679c_1_mwpm_03200403.jpg"},{"uniquekey":"92524831e641315f61e6b7f055a0fcba","title":"iPhone 12发布会将延期？新机或将采用无刘海全面屏设计","date":"2020-04-08 15:32","category":"科技","author_name":"搜狐新闻","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153200670.html","thumbnail_pic_s":"https://03imgmini.eastday.com/mobile/20200408/20200408153200_950ceed6ba7214f7645274a2f95e22cc_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03imgmini.eastday.com/mobile/20200408/20200408153200_950ceed6ba7214f7645274a2f95e22cc_1_mwpm_03200403.jpg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    @Override
    public String toString() {
        return "JsonResult{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"e7bf6b07d5deb68169a9bec5a5a59fa8","title":"想尽一切办法让iPhone12不延期，苹果居然这样做？","date":"2020-04-08 15:44","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408154418194.html","thumbnail_pic_s":"https://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_2_mwpm_03200403.jpg"},{"uniquekey":"2d48edd6706e5e0b6b8f513af0e5bf80","title":"全球新冠肺炎COVID-19实时追踪，关注全球疫情动态","date":"2020-04-08 15:49:37","category":"头条","author_name":"健康资讯","url":"https://covid-19.juheapi.com/?s=toutiao","thumbnail_pic_s":"https://juheimgs.oss-cn-beijing.aliyuncs.com/banner/202003/d8376e7e3010cc3f.png","thumbnail_pic_s02":"https://juheimgs.oss-cn-beijing.aliyuncs.com/banner/202003/d8376e7e3010cc3f.png","thumbnail_pic_s03":"https://juheimgs.oss-cn-beijing.aliyuncs.com/banner/202003/d8376e7e3010cc3f.png"},{"uniquekey":"6cb20e6f048fe2ca062ba2ebe9845f45","title":"一波直观预测！PS5 & PS4手柄大小/设计叠图对比","date":"2020-04-08 15:39","category":"科技","author_name":"游侠网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153937062.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153937_fb50cfdb03dae44c5d6dc00f38cceb0e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153937_fb50cfdb03dae44c5d6dc00f38cceb0e_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/20200408153937_fb50cfdb03dae44c5d6dc00f38cceb0e_3_mwpm_03200403.jpg"},{"uniquekey":"5280798aa3c46b2253f0579b414d2832","title":"手机厂商扎堆进军！华为或将发布65W氮化镓充电器","date":"2020-04-08 15:37","category":"科技","author_name":"爱集微","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153741015.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153741_d601df10d3763dbc392fc015e3815b92_1_mwpm_03200403.jpg"},{"uniquekey":"534bdcb759a407491f59e83a6b1ee3dc","title":"iPhone9 真的要来了？现已加入美国以旧换新套餐","date":"2020-04-08 15:36","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153607025.html","thumbnail_pic_s":"https://00imgmini.eastday.com/mobile/20200408/20200408153607_4069a0507e9b2f394469b3a0295b9536_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00imgmini.eastday.com/mobile/20200408/20200408153607_4069a0507e9b2f394469b3a0295b9536_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00imgmini.eastday.com/mobile/20200408/20200408153607_4069a0507e9b2f394469b3a0295b9536_1_mwpm_03200403.jpg"},{"uniquekey":"cbd6663288bb89366ec01ecf43851499","title":"原创 骁龙865+120Hz高刷屏 iQOO Neo3核心配置曝光 或预定性能排行榜首","date":"2020-04-08 15:35","category":"科技","author_name":"机智万象","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153549027.html","thumbnail_pic_s":"https://02imgmini.eastday.com/mobile/20200408/20200408153549_a22c7779a6a83749cd25183d7b70171c_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02imgmini.eastday.com/mobile/20200408/20200408153549_a22c7779a6a83749cd25183d7b70171c_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02imgmini.eastday.com/mobile/20200408/20200408153549_a22c7779a6a83749cd25183d7b70171c_5_mwpm_03200403.jpg"},{"uniquekey":"23b3ed19e5b883f371cbea09f9704dc2","title":"三星新机通过 WiFi 联盟认证，或将在近期发布","date":"2020-04-08 15:35","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153544889.html","thumbnail_pic_s":"https://03imgmini.eastday.com/mobile/20200408/20200408153544_4840c7750a551674cc174093daa446cd_1_mwpm_03200403.jpg"},{"uniquekey":"0643e0bf49de13bacb1a4ad13954c66c","title":"同价位罕有 3 倍光学变焦 荣耀 30S 同一场景如何发挥多摄优势？","date":"2020-04-08 15:35","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153540361.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153540_c4e13d9f6cad69ff255d2646edacde86_21_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153540_c4e13d9f6cad69ff255d2646edacde86_16_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/20200408153540_c4e13d9f6cad69ff255d2646edacde86_1_mwpm_03200403.jpg"},{"uniquekey":"3c90243787526d91ef6af17e15e888d5","title":"安兔兔三月跑分出炉，这款中端 SOC 蝉联冠军","date":"2020-04-08 15:35","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153530172.html","thumbnail_pic_s":"https://03imgmini.eastday.com/mobile/20200408/20200408153530_9f8e5bbfbfde583e7a4f0b5fd03ac695_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03imgmini.eastday.com/mobile/20200408/20200408153530_9f8e5bbfbfde583e7a4f0b5fd03ac695_2_mwpm_03200403.jpg"},{"uniquekey":"da7a32efc32b1db8a31b8e97eefaa5a9","title":"苹果公布自家防护面罩说明文档 每周将生产100万个","date":"2020-04-08 15:35","category":"科技","author_name":"天极网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153508153.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153508_310b299c5a3e663b1cfaddfe96a99fcc_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20200408/20200408153508_310b299c5a3e663b1cfaddfe96a99fcc_2_mwpm_03200403.jpg"},{"uniquekey":"7c1d385f050a0b7f617cd3c6ff3e4b76","title":"9.9元包邮和69元的黑科技，差价7倍你选哪个？飞智影刺上手体验","date":"2020-04-08 15:34","category":"科技","author_name":"定焦科技","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153448275.html","thumbnail_pic_s":"https://09imgmini.eastday.com/mobile/20200408/20200408153448_07e2cb6408f7f3422b6f9f7c87390908_22_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09imgmini.eastday.com/mobile/20200408/20200408153448_07e2cb6408f7f3422b6f9f7c87390908_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09imgmini.eastday.com/mobile/20200408/20200408153448_07e2cb6408f7f3422b6f9f7c87390908_20_mwpm_03200403.jpg"},{"uniquekey":"d2df50accc9e496f4f86cebda1793fb7","title":"三星 Note20 系列模具遭曝光，保留实体键采用相机矩阵","date":"2020-04-08 15:34","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153435550.html","thumbnail_pic_s":"https://01imgmini.eastday.com/mobile/20200408/20200408153435_e767a9bd60baee26084ce4e37f9c6876_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01imgmini.eastday.com/mobile/20200408/20200408153435_e767a9bd60baee26084ce4e37f9c6876_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01imgmini.eastday.com/mobile/20200408/20200408153435_e767a9bd60baee26084ce4e37f9c6876_2_mwpm_03200403.jpg"},{"uniquekey":"8e9653211a2e02df49f59ac7bfe7155e","title":"英伟达迎来强大竞争对手：华为计划今年打入 GPU 服务器市场","date":"2020-04-08 15:34","category":"科技","author_name":"天极网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153433271.html","thumbnail_pic_s":"https://09imgmini.eastday.com/mobile/20200408/20200408153433_f0d47e6c3a1a023bbb3bee48a82f6470_1_mwpm_03200403.jpg"},{"uniquekey":"b1c8c9c5e7d5b075c71a7047d720f904","title":"长亭科技推出重大活动网络安全保障解决方案","date":"2020-04-08 15:34","category":"科技","author_name":"砍柴网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153432529.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153432_2297b84c2581ea2b592c8d4db735ac9e_1_mwpm_03200403.jpg"},{"uniquekey":"7e9ff5f7516f2772be632dd9dcdb13b0","title":"英特尔Mozilla等企业宣布加入Open COVID Pledge技术开放联盟","date":"2020-04-08 15:34","category":"科技","author_name":"cnBeta","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153422094.html","thumbnail_pic_s":"https://00imgmini.eastday.com/mobile/20200408/20200408153422_87eddaae53bb21b2857bdd45a0372f33_1_mwpm_03200403.jpg"},{"uniquekey":"d773872827669a7d71b284afc2773f61","title":"将大像素进行到底，小米 CC10 Pro 将首发 1.92 亿像素","date":"2020-04-08 15:34","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153421864.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153421_09a0c0a1a88a0fb0af54ae509b7d020c_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153421_09a0c0a1a88a0fb0af54ae509b7d020c_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/20200408153421_09a0c0a1a88a0fb0af54ae509b7d020c_2_mwpm_03200403.jpg"},{"uniquekey":"f52a050448eaecdd91fb6b4deddbc7e9","title":"小米有品新品：4年续航，不用钥匙手机也能开锁","date":"2020-04-08 15:34","category":"科技","author_name":"吖有","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153419452.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/2020040815_dfc0e05e43e543edbb0b2dcbcbd54b31_6607_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/2020040815_2c9193c797704ee4ade9fa5da0ab2f2c_6469_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/2020040815_9dea5adf813c4b52bb165aba6c4e57a5_1359_cover_mwpm_03200403.jpg"},{"uniquekey":"3b379a8f3388350b7b3950bd450469a6","title":"多倍乐趣 多倍体验 三星 Galaxy S20 5G 系列才是当下真顶级旗舰","date":"2020-04-08 15:34","category":"科技","author_name":"砍柴网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153409087.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153409_8e3bd1990f852e17a0528241fee70fc0_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20200408/20200408153409_8e3bd1990f852e17a0528241fee70fc0_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07imgmini.eastday.com/mobile/20200408/20200408153409_8e3bd1990f852e17a0528241fee70fc0_3_mwpm_03200403.jpg"},{"uniquekey":"c330cbcd98fc5368f5240093dc643796","title":"苹果新专利曝光，喜欢躺着玩手机的人注意了！","date":"2020-04-08 15:34","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153402702.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153402_93388162f57943541b30d0cb42d4c6c8_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153402_93388162f57943541b30d0cb42d4c6c8_1_mwpm_03200403.jpg"},{"uniquekey":"36c7e0ee122fe61624999aa11da30a50","title":"Netflix将允许家长删除部分节目 为孩子筛选内容","date":"2020-04-08 15:34","category":"科技","author_name":"澎湃新闻网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153401887.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153401_191486406fa9255939e534ac363277a8_1_mwpm_03200403.jpg"},{"uniquekey":"f14d1b66852bdf40f18d88f24cc74e37","title":"王雪红：VR 给予人类突破局限，促使科技与人文结合","date":"2020-04-08 15:33","category":"科技","author_name":"砍柴网","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153358791.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153358_af374772ead6de1efeebec871df9d257_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20200408/20200408153358_af374772ead6de1efeebec871df9d257_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07imgmini.eastday.com/mobile/20200408/20200408153358_af374772ead6de1efeebec871df9d257_5_mwpm_03200403.jpg"},{"uniquekey":"b2ec4b2711c2e0ddef3b332f8db41ea7","title":"国产生产商长脸了！黑鲨 3 Pro 搭载的京东方屏幕获好评","date":"2020-04-08 15:33","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153335701.html","thumbnail_pic_s":"https://03imgmini.eastday.com/mobile/20200408/20200408153335_e690e8e6d73f959e41b80ae13d3aa785_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03imgmini.eastday.com/mobile/20200408/20200408153335_e690e8e6d73f959e41b80ae13d3aa785_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03imgmini.eastday.com/mobile/20200408/20200408153335_e690e8e6d73f959e41b80ae13d3aa785_3_mwpm_03200403.jpg"},{"uniquekey":"772b6d6ae33491f5e6cd39d717493e1a","title":"苹果再次驰援\u201c小弟\u201d JDI，花 2 亿买了一批\u201c废铁\u201d","date":"2020-04-08 15:33","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153305940.html","thumbnail_pic_s":"https://04imgmini.eastday.com/mobile/20200408/20200408153305_f7d27461dc8f716050f1526f2f1ec789_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04imgmini.eastday.com/mobile/20200408/20200408153305_f7d27461dc8f716050f1526f2f1ec789_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04imgmini.eastday.com/mobile/20200408/20200408153305_f7d27461dc8f716050f1526f2f1ec789_3_mwpm_03200403.jpg"},{"uniquekey":"d8d7dae2a00901b572ccd0b670d0e708","title":"高分 APP 被苹果收购，安卓用户在 7 月 1 日后没法享用了","date":"2020-04-08 15:33","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153303642.html","thumbnail_pic_s":"https://01imgmini.eastday.com/mobile/20200408/20200408153303_4318ba40efec3613cfe78300cc41faff_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01imgmini.eastday.com/mobile/20200408/20200408153303_4318ba40efec3613cfe78300cc41faff_2_mwpm_03200403.jpg"},{"uniquekey":"c723cfa8d6bff889146a9f0af69bea63","title":"iPhone 9 再被曝光，或许能在 4 月 5 日之后发布？","date":"2020-04-08 15:32","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153250872.html","thumbnail_pic_s":"https://02imgmini.eastday.com/mobile/20200408/20200408153250_38b73b213a3ce76b300ed407ae8e800b_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02imgmini.eastday.com/mobile/20200408/20200408153250_38b73b213a3ce76b300ed407ae8e800b_2_mwpm_03200403.jpg"},{"uniquekey":"cae229a7f21790523f22e99d4722d92a","title":"vivo再发新机Y50，千元档主打性价比，却被吐槽产品线混乱","date":"2020-04-08 15:32","category":"科技","author_name":"科技视镜","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153238587.html","thumbnail_pic_s":"https://01imgmini.eastday.com/mobile/20200408/2020040815_aca6dc5a65274344888e035237f13889_7587_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01imgmini.eastday.com/mobile/20200408/2020040815_635ef86d807a4f51b6503a61be5fdac3_0323_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01imgmini.eastday.com/mobile/20200408/2020040815_eab0a63906d744608c04daedc827823f_1270_cover_mwpm_03200403.jpg"},{"uniquekey":"db4e5d571697315ac5a2493767503cd6","title":"666 元的 Redmi 新机？甚至还有 18W 快充","date":"2020-04-08 15:32","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153230987.html","thumbnail_pic_s":"https://07imgmini.eastday.com/mobile/20200408/20200408153230_75a8950275510af26a7008d6cdf40cab_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20200408/20200408153230_75a8950275510af26a7008d6cdf40cab_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07imgmini.eastday.com/mobile/20200408/20200408153230_75a8950275510af26a7008d6cdf40cab_3_mwpm_03200403.jpg"},{"uniquekey":"8cc0c6ab9cbb6ad0db72f28e98b2bd4c","title":"iPhone 9 多项参数配置曝光，续航将会猛增？","date":"2020-04-08 15:32","category":"科技","author_name":"IT168","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153227562.html","thumbnail_pic_s":"https://02imgmini.eastday.com/mobile/20200408/20200408153227_c7fd04a9141eaef452a6a226e57fe6bd_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02imgmini.eastday.com/mobile/20200408/20200408153227_c7fd04a9141eaef452a6a226e57fe6bd_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02imgmini.eastday.com/mobile/20200408/20200408153227_c7fd04a9141eaef452a6a226e57fe6bd_2_mwpm_03200403.jpg"},{"uniquekey":"c5e90c61109ded239d33ee6b3a82d7fa","title":"千东商城：打通互联网公司、高净值用户和优质商品的桥梁","date":"2020-04-08 15:32","category":"科技","author_name":"美通社","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153203564.html","thumbnail_pic_s":"https://08imgmini.eastday.com/mobile/20200408/20200408153203_ff6a525197c7e5d6757576a31703679c_1_mwpm_03200403.jpg"},{"uniquekey":"92524831e641315f61e6b7f055a0fcba","title":"iPhone 12发布会将延期？新机或将采用无刘海全面屏设计","date":"2020-04-08 15:32","category":"科技","author_name":"搜狐新闻","url":"https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408153200670.html","thumbnail_pic_s":"https://03imgmini.eastday.com/mobile/20200408/20200408153200_950ceed6ba7214f7645274a2f95e22cc_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03imgmini.eastday.com/mobile/20200408/20200408153200_950ceed6ba7214f7645274a2f95e22cc_1_mwpm_03200403.jpg"}]
         */

        private String stat;
        private List<DataBean> data;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "stat='" + stat + '\'' +
                    ", data=" + data +
                    '}';
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : e7bf6b07d5deb68169a9bec5a5a59fa8
             * title : 想尽一切办法让iPhone12不延期，苹果居然这样做？
             * date : 2020-04-08 15:44
             * category : 科技
             * author_name : IT168
             * url : https://v.juhe.cn/toutiao/s?id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200408154418194.html
             * thumbnail_pic_s : https://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_3_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_1_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://02imgmini.eastday.com/mobile/20200408/20200408154418_636ca8c96ace3b8822dd51c7b2d46372_2_mwpm_03200403.jpg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            @Override
            public String toString() {
                return "DataBean{" +
                        "uniquekey='" + uniquekey + '\'' +
                        ", title='" + title + '\'' +
                        ", date='" + date + '\'' +
                        ", category='" + category + '\'' +
                        ", author_name='" + author_name + '\'' +
                        ", url='" + url + '\'' +
                        ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                        ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                        ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                        '}';
            }

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}


