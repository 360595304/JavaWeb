/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : store

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 18/12/2021 18:02:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `press` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isbn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Python编程 从入门到实践 第2版', '[美]埃里克·马瑟斯', 105.1, '人民邮电出版社', '9787115546081', '零基础学Python编程教程书籍，数据分析、网络爬虫、深度学习技能，畅销经典蟒蛇书升级版，附赠源代码、练习答案、学习视频、学习速查地图读者交流群等资源。');
INSERT INTO `book` VALUES (8, 'C++ Primer Plus 第6版 中文版', '[美] 史蒂芬·普拉达', 59, '人民邮电出版社', '9787115521644', 'C++程序设计经典教程，畅销30年的C++大百科全书全新升级，经典C++入门教程十年新版再现，孟岩、高博倾力推荐，赠送价值99元的e读版电子书及在线实验环境，赠送大尺寸全书思维导图，赠199元训练营');
INSERT INTO `book` VALUES (9, '利用Python进行数据分析（原书第2版）', '[美]韦斯·麦金尼', 110.5, '机械工业出版社', '9787111603702', 'Python数据分析经典畅销书全新升级，第1版中文版累计销售100000册 Python pandas创始人亲自执笔，Python语言的核心开发人员鼎立推荐 针对Python 3.6进行全面修订和更新');
INSERT INTO `book` VALUES (10, 'JavaScript高级程序设计 第4版', '[美]马特·弗里斯比', 123.5, '人民邮电出版社', '9787115545381', 'web前端开发经典教程，JS“红宝书”全新升级，入门+实战，涵盖ECMAScript 2019，提供教学视频+配套编程环境，可直接在线运行随书代码');
INSERT INTO `book` VALUES (11, '深入理解Java虚拟机：JVM高级特性与实践（第3版）', '周志明', 119.8, '机械工业出版社', '9787111641247', '周志明虚拟机新作，第3版新增内容近50%，5个维度全面剖析JVM，大厂面试知识点全覆盖。与 Java编程思想、Effective Java、Java核心技术 堪称：Java四大名著');
INSERT INTO `book` VALUES (12, 'Head First Java（中文版）', '[美]塞若，[美]贝茨', 37.2, '中国电力出版社', '9787508344980', '10年畅销经典，累计印刷30多次，畅销近30万册，计算机图书十大好书之一。');
INSERT INTO `book` VALUES (13, 'Spring Cloud Alibaba 微服务架构实战派（上下册）', '胡弦', 118, '电子工业出版社', '9787121423130', '学完Springboot该学微服务，学这本了。不仅有Spring Cloud Alibaba，还有微服务涉及的相关技术（比如Seata、Skywalking、Redis、RocketMQ等），实战性强');
INSERT INTO `book` VALUES (14, 'Java编程思想（第4版）', '[美] Bruce Eckel', 100.3, '机械工业出版社', '9787111213826', 'Java学习经典,殿堂级著作！赢得了全球程序员的广泛赞誉。');
INSERT INTO `book` VALUES (15, 'C++ Primer中文版（第5版）', '[美]李普曼 等', 118.9, '电子工业出版社', '9787121155352', 'C++学习头牌 全球读者千万 全面采用新标 技术影响力图书冠军');
INSERT INTO `book` VALUES (16, 'C++并发编程实战（第2版）', '[英]安东尼·威廉姆斯', 133.8, '人民邮电出版社', '9787115573551', 'C++并发编程深度指南，C++标准委员会成员编写，囊括C++并发编程多个方面，代码附有中文注释简洁易懂，附赠配套代码文件。');
INSERT INTO `book` VALUES (17, 'Java核心技术 卷I 基础知识（原书第11版）', '[美],凯·S.霍斯特曼', 138.4, '机械工业出版社', '9787111636663', 'Core Java 第11版，Jolt大奖获奖作品，针对Java SE9、10、11全面更新，与Java编程思想、Effective Java、深入理解Java虚拟机 堪称：Java四大名著');
INSERT INTO `book` VALUES (18, '算法(第4版)', '[美]Robert Sedgewick　Kevin Wayne', 124.3, '人民邮电出版社', '9787115293800', '【图灵程序设计丛书】算法领域的经典参考书 众多图例实现图解算法和算法导论 基于Java语言实现算法和数据结构 熟练掌握算法设计与分析');
INSERT INTO `book` VALUES (19, 'Java编程思想（第4版）', '[美] Bruce Eckel', 100.3, '机械工业出版社', '9787111213826', 'Java学习经典,殿堂级著作！赢得了全球程序员的广泛赞誉。');
INSERT INTO `book` VALUES (20, 'Java编程思想（第4版）', '[美] Bruce Eckel', 100.3, '机械工业出版社', '9787111213826', 'Java学习经典,殿堂级著作！赢得了全球程序员的广泛赞誉。');
INSERT INTO `book` VALUES (22, 'Java编程思想（第4版）', '[美] Bruce Eckel', 100.3, '机械工业出版社', '9787111213826', 'Java学习经典,殿堂级著作！赢得了全球程序员的广泛赞誉。');
INSERT INTO `book` VALUES (23, 'Java编程思想（第4版）', '[美] Bruce Eckel', 100.3, '机械工业出版社', '9787111213826', 'Java学习经典,殿堂级著作！赢得了全球程序员的广泛赞誉。');
INSERT INTO `book` VALUES (24, 'Java编程思想（第4版）', '[美] Bruce Eckel', 100.3, '机械工业出版社', '9787111213826', 'Java学习经典,殿堂级著作！赢得了全球程序员的广泛赞誉。');
INSERT INTO `book` VALUES (25, 'Java编程思想（第4版）', '[美] Bruce Eckel', 100.3, '机械工业出版社', '9787111213826', 'Java学习经典,殿堂级著作！赢得了全球程序员的广泛赞誉。');
INSERT INTO `book` VALUES (26, 'C++ Primer中文版（第5版）', '[美]李普曼 等', 118.9, '电子工业出版社', '9787121155352', 'C++学习头牌 全球读者千万 全面采用新标 技术影响力图书冠军');
INSERT INTO `book` VALUES (27, 'C++ Primer中文版（第5版）', '[美]李普曼 等', 118.9, '电子工业出版社', '9787121155352', 'C++学习头牌 全球读者千万 全面采用新标 技术影响力图书冠军');
INSERT INTO `book` VALUES (28, 'C++ Primer中文版（第5版）', '[美]李普曼 等', 118.9, '电子工业出版社', '9787121155352', 'C++学习头牌 全球读者千万 全面采用新标 技术影响力图书冠军');
INSERT INTO `book` VALUES (29, 'C++ Primer中文版（第5版）', '[美]李普曼 等', 118.9, '电子工业出版社', '9787121155352', 'C++学习头牌 全球读者千万 全面采用新标 技术影响力图书冠军');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '19202030123', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
