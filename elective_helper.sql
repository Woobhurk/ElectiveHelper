/*
 Navicat Premium Data Transfer

 Source Server         : ElectiveHelper
 Source Server Type    : MySQL
 Source Server Version : 100404
 Source Host           : localhost:3306
 Source Schema         : course_selecting

 Target Server Type    : MySQL
 Target Server Version : 100404
 File Encoding         : 65001

 Date: 14/04/2019 10:19:08
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `room` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (1, 'building1', '1001');
INSERT INTO `classroom` VALUES (7, 'building5', '320');
INSERT INTO `classroom` VALUES (8, 'building8', '408');
INSERT INTO `classroom` VALUES (9, 'building8', '817');
INSERT INTO `classroom` VALUES (10, 'building5', '906');
INSERT INTO `classroom` VALUES (11, 'building6', '402');
INSERT INTO `classroom` VALUES (12, 'building2', '518');
INSERT INTO `classroom` VALUES (13, 'building9', '314');
INSERT INTO `classroom` VALUES (14, 'building3', '707');
INSERT INTO `classroom` VALUES (15, 'building7', '603');
INSERT INTO `classroom` VALUES (16, 'building5', '304');
INSERT INTO `classroom` VALUES (17, 'building5', '905');
INSERT INTO `classroom` VALUES (18, 'building3', '719');
INSERT INTO `classroom` VALUES (19, 'building3', '808');
INSERT INTO `classroom` VALUES (20, 'building3', '219');
INSERT INTO `classroom` VALUES (21, 'building2', '206');
INSERT INTO `classroom` VALUES (22, 'building9', '720');
INSERT INTO `classroom` VALUES (23, 'building6', '205');
INSERT INTO `classroom` VALUES (24, 'building4', '218');
INSERT INTO `classroom` VALUES (25, 'building8', '413');
INSERT INTO `classroom` VALUES (26, 'building9', '805');
INSERT INTO `classroom` VALUES (27, 'building7', '913');
INSERT INTO `classroom` VALUES (28, 'building3', '608');
INSERT INTO `classroom` VALUES (29, '???', '101');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `startTime` datetime(0) NOT NULL,
  `endTime` datetime(0) NOT NULL,
  `classroomId` int(11) NULL DEFAULT NULL,
  `dayOfWeek` int(11) NOT NULL,
  `classOfDay` int(11) NOT NULL,
  `rateTotal` int(11) NULL DEFAULT NULL,
  `rateCount` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_classroom_id_fk`(`classroomId`) USING BTREE,
  INDEX `course_teacher_id_fk`(`teacherId`) USING BTREE,
  CONSTRAINT `course_classroom_id_fk` FOREIGN KEY (`classroomId`) REFERENCES `classroom` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `course_teacher_id_fk` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (4, 28, 'Course056', 'Automatically generated 87701231', '2017-01-26 09:18:19', '2017-08-29 23:03:18', 14, 7, 2, 305, 64);
INSERT INTO `course` VALUES (7, 33, 'Course051', 'Automatically generated 52888748', '2015-02-04 07:12:06', '2018-03-11 04:47:26', 24, 5, 5, 101, 31);
INSERT INTO `course` VALUES (10, 7, 'Course020', 'Automatically generated 73918359', '2015-05-20 01:23:46', '2017-11-18 05:27:33', 16, 4, 1, 102, 34);
INSERT INTO `course` VALUES (12, 2, 'Course047', 'Automatically generated 42053218', '2017-04-11 21:27:35', '2017-12-03 14:42:45', 21, 1, 3, 340, 80);
INSERT INTO `course` VALUES (18, 5, 'Course017', 'Automatically generated 48064865', '2018-03-03 22:21:59', '2018-06-15 05:36:23', 9, 3, 2, 136, 42);
INSERT INTO `course` VALUES (19, 16, 'Course010', 'Automatically generated 68838727', '2015-08-26 08:13:59', '2016-08-29 04:54:03', 18, 3, 3, 259, 58);
INSERT INTO `course` VALUES (20, 30, 'Course018', 'Automatically generated 31406456', '2015-05-15 13:17:46', '2015-09-11 20:05:57', 17, 5, 3, 32, 9);
INSERT INTO `course` VALUES (21, 23, 'Course001', 'Automatically generated 8816984', '2016-10-25 18:16:03', '2017-06-16 10:38:51', 15, 3, 2, 273, 74);
INSERT INTO `course` VALUES (22, 33, 'Course037', 'Automatically generated 67348107', '2016-05-01 00:59:55', '2017-05-28 17:41:20', 19, 7, 5, 333, 72);
INSERT INTO `course` VALUES (24, 33, 'Course084', 'Automatically generated 82773854', '2017-09-14 06:03:24', '2018-02-01 16:25:02', 27, 4, 3, 92, 30);
INSERT INTO `course` VALUES (26, 23, 'Course075', 'Automatically generated 65010497', '2015-02-18 16:34:48', '2016-01-14 03:14:48', 14, 3, 3, 304, 68);
INSERT INTO `course` VALUES (27, 22, 'Course007', 'Automatically generated 85699405', '2015-11-07 08:11:51', '2017-12-22 20:58:20', 23, 6, 4, 45, 11);
INSERT INTO `course` VALUES (30, 3, 'Course028', 'Automatically generated 49534037', '2017-10-28 10:13:53', '2018-02-16 03:05:04', 9, 2, 1, 106, 25);
INSERT INTO `course` VALUES (31, 8, 'Course037', 'Automatically generated 14135800', '2017-09-19 00:13:03', '2017-11-20 14:59:10', 27, 1, 3, 297, 77);
INSERT INTO `course` VALUES (32, 15, 'Course095', 'Automatically generated 57207919', '2015-06-01 19:05:56', '2016-06-24 16:03:13', 27, 1, 3, 326, 91);
INSERT INTO `course` VALUES (33, 13, 'Course075', 'Automatically generated 85588479', '2015-08-02 09:42:26', '2015-12-18 02:45:27', 7, 6, 5, 36, 11);
INSERT INTO `course` VALUES (34, 2, 'Course070', 'Automatically generated 7814331', '2016-04-16 18:14:53', '2017-01-02 01:06:25', 23, 5, 4, 130, 27);
INSERT INTO `course` VALUES (36, 15, 'Course059', 'Automatically generated 76887329', '2015-03-22 01:08:28', '2018-07-17 08:57:48', 9, 2, 3, 60, 19);
INSERT INTO `course` VALUES (40, 31, 'Course070', 'Automatically generated 51678083', '2016-11-01 10:09:28', '2018-11-24 10:47:36', 21, 4, 2, 352, 81);
INSERT INTO `course` VALUES (41, 12, 'Course047', 'Automatically generated 17510800', '2016-12-06 02:55:20', '2018-09-25 23:22:57', 21, 3, 1, 82, 25);
INSERT INTO `course` VALUES (43, 7, 'Course026', 'Automatically generated 78583127', '2015-06-19 21:34:11', '2016-09-21 11:13:42', 25, 2, 2, 140, 32);
INSERT INTO `course` VALUES (44, 26, 'Course021', 'Automatically generated 75459251', '2015-06-27 03:54:12', '2016-08-15 14:29:36', 20, 1, 5, 6, 2);
INSERT INTO `course` VALUES (47, 24, 'Course100', 'Automatically generated 44180123', '2015-11-17 06:44:49', '2018-03-05 03:20:14', 11, 2, 4, 24, 5);
INSERT INTO `course` VALUES (48, 33, 'Course042', 'Automatically generated 33249309', '2016-02-09 04:03:41', '2016-06-10 06:25:17', 10, 7, 2, 410, 89);
INSERT INTO `course` VALUES (49, 12, 'Course002', 'Automatically generated 8855897', '2016-09-08 04:10:17', '2018-12-28 18:03:56', 19, 7, 5, 29, 9);
INSERT INTO `course` VALUES (50, 20, 'Course026', 'Automatically generated 76014642', '2015-12-18 02:47:36', '2017-07-24 08:18:29', 18, 2, 1, 168, 47);
INSERT INTO `course` VALUES (51, 4, 'Course044', 'Automatically generated 86964393', '2015-08-03 11:08:14', '2018-04-05 20:43:06', 14, 3, 1, 54, 18);
INSERT INTO `course` VALUES (52, 26, 'Course057', 'Automatically generated 97645942', '2015-12-08 10:24:45', '2017-05-11 13:51:31', 8, 6, 5, 258, 74);
INSERT INTO `course` VALUES (53, 7, 'Course058', 'Automatically generated 42636292', '2016-09-10 13:48:22', '2016-12-19 05:18:46', 28, 5, 1, 242, 73);
INSERT INTO `course` VALUES (54, 29, 'Course021', 'Automatically generated 20892644', '2016-06-05 07:09:49', '2017-10-29 11:30:04', 26, 1, 1, 293, 94);
INSERT INTO `course` VALUES (60, 34, 'Course050', 'Automatically generated 91358252', '2015-09-06 19:36:33', '2018-03-02 16:14:10', 10, 2, 5, 362, 78);
INSERT INTO `course` VALUES (61, 16, 'Course014', 'Automatically generated 41329414', '2017-01-06 20:39:45', '2018-10-19 15:27:16', 7, 3, 2, 479, 98);
INSERT INTO `course` VALUES (62, 12, 'Course090', 'Automatically generated 17076421', '2015-05-12 20:58:23', '2018-10-03 23:33:54', 26, 5, 4, 111, 32);
INSERT INTO `course` VALUES (64, 32, 'Course056', 'Automatically generated 77758605', '2015-10-11 10:01:49', '2015-10-25 19:27:54', 10, 1, 1, 124, 33);
INSERT INTO `course` VALUES (65, 31, 'Course002', 'Automatically generated 48922432', '2016-06-10 01:24:48', '2018-11-21 21:27:33', 16, 4, 1, 30, 9);
INSERT INTO `course` VALUES (66, 12, 'Course032', 'Automatically generated 21992230', '2015-02-08 21:35:19', '2018-03-15 22:14:22', 9, 4, 1, 465, 98);
INSERT INTO `course` VALUES (68, 34, 'Course056', 'Automatically generated 4257107', '2017-07-05 02:07:16', '2018-02-16 10:27:04', 28, 5, 3, 90, 20);
INSERT INTO `course` VALUES (71, 7, 'Course052', 'Automatically generated 75075439', '2015-10-13 17:24:46', '2017-02-17 10:28:03', 26, 3, 4, 33, 10);
INSERT INTO `course` VALUES (72, 17, 'Course011', 'Automatically generated 30605615', '2015-02-28 09:03:07', '2016-12-15 15:34:59', 12, 3, 5, 32, 8);

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `senderId` int(11) NULL DEFAULT NULL,
  `receiverId` int(11) NULL DEFAULT NULL,
  `msgTime` datetime(0) NULL DEFAULT NULL,
  `msgText` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `msg_receiverId_user_id_fk`(`receiverId`) USING BTREE,
  INDEX `msg_senderId_user_id_fk`(`senderId`) USING BTREE,
  CONSTRAINT `msg_receiverId_user_id_fk` FOREIGN KEY (`receiverId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `msg_senderId_user_id_fk` FOREIGN KEY (`senderId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 422 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES (67, 1, 8, '2018-10-02 20:09:13', '7d0492794474dd4e94f1274f3799');
INSERT INTO `msg` VALUES (173, 49, 73, '2019-10-08 23:07:41', '529707a88eee2fba091f65f7073f314482495e8caed5bb1df40');
INSERT INTO `msg` VALUES (174, 53, 48, '2018-04-26 11:43:15', '01d262f5c552eea7eec2276974a4a5b7a7aa989147ee2d86f167d6d69e1f70');
INSERT INTO `msg` VALUES (175, 90, 76, '2019-07-18 08:58:48', 'a2753c0ff114cae5');
INSERT INTO `msg` VALUES (177, 46, 44, '2018-07-07 08:09:43', '08c48f80733d337c63dca37cced18e9fb9fc1c844f1f91b684ec5a6');
INSERT INTO `msg` VALUES (178, 45, 55, '2018-02-25 22:08:51', 'c2e97eac7a54f254d');
INSERT INTO `msg` VALUES (183, 92, 46, '2018-01-20 07:33:49', '1898e5fde629399168b281b11bdf1');
INSERT INTO `msg` VALUES (184, 89, 60, '2018-10-19 21:32:01', 'c6d06cc46e4a94a77373');
INSERT INTO `msg` VALUES (185, 93, 54, '2019-05-26 06:39:31', '5b779c3eb4');
INSERT INTO `msg` VALUES (190, 49, 92, '2018-08-25 06:52:33', 'c64014fe3f124ff4097e434a29fcdde42f2663817f8c4d5');
INSERT INTO `msg` VALUES (193, 60, 83, '2019-08-17 00:24:58', '037a6fc168412f8d075eb95ccce26ad4bfcae3c92ef75a94b1f');
INSERT INTO `msg` VALUES (196, 47, 92, '2018-09-09 06:23:13', 'bfc54bbf869809e4d9dbf251bb3ec284063461a77eb5c483c2373d6c4be3');
INSERT INTO `msg` VALUES (199, 57, 55, '2019-09-23 20:51:47', '7eedeaa5bdbbf');
INSERT INTO `msg` VALUES (201, 58, 50, '2018-01-19 01:22:42', '262dce80b6ebdfb');
INSERT INTO `msg` VALUES (205, 40, 92, '2019-09-29 19:01:45', '0d18421ce9acf41f1e8ba2ae3c0dcbd9449b49384cee1311931fa64');
INSERT INTO `msg` VALUES (206, 72, 73, '2018-10-27 03:57:23', 'fbd31e33d57729a19f33d6ff0e3711cb7717a0a7d');
INSERT INTO `msg` VALUES (207, 80, 36, '2019-04-29 22:39:32', '9b40f9bf224b2256e69653ebf5b984f856a37e');
INSERT INTO `msg` VALUES (208, 43, 41, '2018-04-07 02:48:48', '086f9d3e3b03a7e2608433aa41f9001014b28b9b12e');
INSERT INTO `msg` VALUES (209, 43, 37, '2018-10-27 03:52:58', '070faad669');
INSERT INTO `msg` VALUES (210, 43, 37, '2018-10-27 03:52:58', '070faad669');
INSERT INTO `msg` VALUES (213, 94, 76, '2019-06-21 05:05:44', '3b317f8b630cf448859d7b59380f1b');
INSERT INTO `msg` VALUES (214, 80, 76, '2018-09-07 20:37:31', '282619de6f2847d9a651e9c86f169a16c2d92174c55');
INSERT INTO `msg` VALUES (217, 52, 73, '2018-08-09 11:36:32', 'f9dec0110d9f83');
INSERT INTO `msg` VALUES (218, 66, 55, '2018-10-12 16:08:42', '2a9a334bf253ae9ebfa589476e82027877f39d1');
INSERT INTO `msg` VALUES (223, 55, 76, '2018-12-16 20:40:49', '5c2547eb86cd28bc0b6b9ef0b1975796a5ec01248c4c9fc6d96543');
INSERT INTO `msg` VALUES (224, 79, 47, '2019-08-17 23:12:07', 'f3490ad51cf0893');
INSERT INTO `msg` VALUES (229, 75, 36, '2018-05-16 13:11:18', '6c27912ef79692a040033d0dd322395b947b');
INSERT INTO `msg` VALUES (231, 78, 59, '2019-01-22 12:18:02', '212d7ac63bdbfc5b6edef2');
INSERT INTO `msg` VALUES (238, 59, 57, '2019-03-29 08:43:35', 'ccec8d300ea3a670ec1719a4');
INSERT INTO `msg` VALUES (239, 52, 74, '2018-12-18 02:43:21', '5ec96eedd4d584');
INSERT INTO `msg` VALUES (240, 60, 89, '2018-08-08 10:21:33', '7583a41a849a44ac95f942615');
INSERT INTO `msg` VALUES (244, 91, 83, '2018-07-09 18:57:30', '281a91dc547f1e331032ea43402384f8f4be714524e7d6786c7d0e5fd5');
INSERT INTO `msg` VALUES (248, 94, 36, '2018-09-04 11:59:32', '6a3a1ac0ddaa82f86c6b11d50bf');
INSERT INTO `msg` VALUES (250, 80, 83, '2019-05-20 05:03:38', '1c3bf99bac966400523b99cfb07f790a6ece3c3f888');
INSERT INTO `msg` VALUES (255, 92, 93, '2018-04-13 05:49:25', '05e6b8af96168d8d74dfe131d032972f412a161672a60e10bf7f03813d77109');
INSERT INTO `msg` VALUES (256, 36, 40, '2018-11-27 00:22:49', '36bc311ae7dfd6a90279cd7ed4fb0f40ef3e1d98e3');
INSERT INTO `msg` VALUES (258, 76, 47, '2019-03-04 00:41:23', '279e865601dadec8a128674ff63b38ce09938d1893dbbc02a1a68');
INSERT INTO `msg` VALUES (260, 78, 41, '2018-06-07 18:07:22', '3bdfcaf4268f12f9ad0cdcf290a58f61a5ec51507b63388bf8490900fe17');
INSERT INTO `msg` VALUES (263, 94, 50, '2018-09-22 12:21:14', '96d7d3a20ac4a6e288b730f7b6b5cb66d78cd72c77863a96');
INSERT INTO `msg` VALUES (265, 49, 46, '2018-07-02 14:52:33', '2e7af7d9d634ea9ed75f76dbf8e8d04430f96ba567a8153d81107');
INSERT INTO `msg` VALUES (266, 89, 43, '2019-05-05 14:31:47', '73246bf58ce2f46bdfa3');
INSERT INTO `msg` VALUES (270, 40, 80, '2019-05-10 10:18:10', '18a67a5b15663b9d8a3f6bc52ac0a872d1e43585282a8a0ec6');
INSERT INTO `msg` VALUES (271, 52, 60, '2019-06-12 16:12:57', 'e285a3b9fa2c4f21406236346985bc9755a25a3aba3669ea9d83efa97ea');
INSERT INTO `msg` VALUES (272, 66, 93, '2019-01-25 06:45:00', '4b9cdc248c4387a3fa37c863d8c02');
INSERT INTO `msg` VALUES (273, 47, 35, '2019-04-14 12:08:11', 'ca3d02750026d50ee197ec8df279d02');
INSERT INTO `msg` VALUES (274, 42, 75, '2019-10-06 10:37:49', '9dc6693787752');
INSERT INTO `msg` VALUES (275, 59, 76, '2019-10-06 10:37:49', '9dc6693787752');
INSERT INTO `msg` VALUES (278, 79, 72, '2018-03-27 22:59:07', '96623b95719199a0e541ae1957152759ecf7e1f9321548c');
INSERT INTO `msg` VALUES (279, 51, 91, '2019-05-26 07:50:19', 'd51a75a79047aaf8a6418c03a0c73d992a9955153');
INSERT INTO `msg` VALUES (282, 89, 57, '2019-09-11 20:07:03', '29f85728ba4a885c1087c4bc28a4aa79dc5ffa2cf80c');
INSERT INTO `msg` VALUES (287, 37, 67, '2019-01-14 06:01:17', 'c48fd309a7939371f0d49704c3c');
INSERT INTO `msg` VALUES (288, 60, 43, '2018-12-28 18:04:03', 'dcf5d923e6a039759e46');
INSERT INTO `msg` VALUES (289, 80, 93, '2019-01-12 22:24:16', 'b63fcdd204a7824df78488ffba58d0b6c00c6f8d8176cc');
INSERT INTO `msg` VALUES (290, 58, 40, '2018-11-19 12:48:26', 'a7b83b15b2553ae71d6a31af12a5e5b');
INSERT INTO `msg` VALUES (292, 44, 80, '2018-01-26 05:32:00', '1366c3ca889a93996c12da39f2af449d536bd2eb21311cd0b271d8a5f2853e');
INSERT INTO `msg` VALUES (294, 59, 83, '2018-01-21 10:07:16', '18d5b44871af6c08e79078828631c600c4e82f849e00');
INSERT INTO `msg` VALUES (297, 92, 76, '2019-12-28 20:22:21', '64f5fd9047f37432caa3823fd4e31f261b8a1819060e7d4');
INSERT INTO `msg` VALUES (300, 90, 52, '2019-06-21 02:19:22', 'e342a4b0208775b3bbea1104201ec87d4e6525ebb5a');
INSERT INTO `msg` VALUES (301, 89, 45, '2018-05-17 18:09:28', 'c028752e8fcb2516000d24bc3e48220ce0b1f4c0b24cd6273db5cf84fc8d081');
INSERT INTO `msg` VALUES (302, 93, 59, '2018-06-10 05:08:03', '0aa8ef459087da');
INSERT INTO `msg` VALUES (303, 41, 55, '2019-02-24 17:10:43', '22b3edca4288db1c92d63a4a8c3a697a5d9a');
INSERT INTO `msg` VALUES (304, 47, 35, '2018-12-12 04:46:19', '22b3edca4288db1c92d63a4a8c3a697a5d9a');
INSERT INTO `msg` VALUES (305, 55, 92, '2018-04-28 23:58:58', 'a57158473af2b695f3d56086f506de4b3c0cd37e7a6bf456ce7c00b7a3f');
INSERT INTO `msg` VALUES (307, 89, 48, '2019-08-16 20:39:46', 'd0b3bb307daad90942be31efa510fd376ed41a90820690beaeb302a1');
INSERT INTO `msg` VALUES (309, 85, 48, '2019-07-21 23:50:16', '1184d8d4d6284698b42bdf785c30e390c2');
INSERT INTO `msg` VALUES (312, 35, 83, '2019-11-20 13:54:49', '3160fc69a19');
INSERT INTO `msg` VALUES (314, 90, 55, '2018-09-28 17:48:48', 'd5bcc44c6d6a5c331f5b0caeebfa75040f410382a3bd9a68');
INSERT INTO `msg` VALUES (315, 74, 45, '2018-04-04 17:10:44', 'd5bcc44c6d6a5c331f5b0caeebfa75040f410382a3bd9a68');
INSERT INTO `msg` VALUES (316, 43, 74, '2019-10-15 01:49:55', '72ca336e9bf8aab3986519c10a772d607c95234c1db0c74c2b7418');
INSERT INTO `msg` VALUES (318, 94, 47, '2019-06-21 02:32:19', 'ba54ad18049b2c15b46d6cfea8db1e4ae2b34383858242068573d');
INSERT INTO `msg` VALUES (320, 92, 72, '2019-08-01 05:07:52', 'f82e9aed7b16dd273d2c9c23b350bb6cd5d7c2cac2c1');
INSERT INTO `msg` VALUES (322, 52, 94, '2019-03-09 19:15:48', '23064ba6bcbdf4ce8ce1b83ec');
INSERT INTO `msg` VALUES (325, 52, 35, '2018-12-24 07:10:54', '488a649ec9cff');
INSERT INTO `msg` VALUES (327, 66, 45, '2018-07-19 13:53:46', '6978db3755ec9db209b799f2a4f30aa9ee153aad5df1f1bfbec25246a');
INSERT INTO `msg` VALUES (329, 35, 66, '2019-07-20 18:58:31', '862819b22c87cf65c68bacc91f8c8de2bda9fab441938e202864bf');
INSERT INTO `msg` VALUES (331, 36, 94, '2019-07-02 15:05:30', '4a17e94f7f018ed9f0eda742347b2d81c19061d2aff3c5f5555');
INSERT INTO `msg` VALUES (332, 91, 74, '2018-11-09 19:12:34', 'cbdb3e27d84dce58fb649e590c0debbd3675bafc5068c6d86246');
INSERT INTO `msg` VALUES (334, 48, 57, '2019-03-08 17:49:00', '0b07873649f0b9da8521e03');
INSERT INTO `msg` VALUES (335, 46, 66, '2018-07-12 08:32:39', '5d377d9a722e1ae8c49aeb00d0177a836d23dcb1ce136065ef88737c835b');
INSERT INTO `msg` VALUES (336, 41, 66, '2019-05-02 04:44:09', '5d377d9a722e1ae8c49aeb00d0177a836d23dcb1ce136065ef88737c835b');
INSERT INTO `msg` VALUES (340, 46, 76, '2018-02-14 02:06:11', '2d139630ca7fa8688d8da822810d3bbb2298cb193760ef8c68ab556');
INSERT INTO `msg` VALUES (342, 50, 79, '2019-07-02 14:53:35', '8ee810c955b59695b8cd84318f8b5afc6dfb68f614');
INSERT INTO `msg` VALUES (344, 58, 83, '2018-12-18 23:07:39', '7d45a7208cc4e73233034d079efb7c732220f7943a224aaf5a7');
INSERT INTO `msg` VALUES (345, 45, 92, '2019-05-29 19:02:45', 'a4da19c4ebcd480d4b47a');
INSERT INTO `msg` VALUES (346, 93, 45, '2018-03-01 09:00:50', '0dd66a201a');
INSERT INTO `msg` VALUES (348, 53, 37, '2018-02-14 22:20:48', '8ae53af9c946c');
INSERT INTO `msg` VALUES (350, 53, 52, '2018-11-22 02:24:42', '9779d8aca964d0d9bd5f125fc842df7b492e8');
INSERT INTO `msg` VALUES (351, 93, 55, '2018-04-06 23:27:16', '9f914607cfacb75a9b96f75644a43b7');
INSERT INTO `msg` VALUES (352, 79, 78, '2019-05-19 03:52:52', 'a4a961f457c3d44b9ab8e58e9ad4e94caf626f64a62b0d45');
INSERT INTO `msg` VALUES (353, 50, 40, '2019-05-19 03:52:52', 'a4a961f457c3d44b9ab8e58e9ad4e94caf626f64a62b0d45');
INSERT INTO `msg` VALUES (355, 66, 53, '2019-12-17 00:21:44', 'f0b2433dbdb8e29ddd5406');
INSERT INTO `msg` VALUES (356, 60, 54, '2019-12-28 22:48:16', '6f543213dbefe8e06ffdf6f07f14d6f7b66aef8667c4b9');
INSERT INTO `msg` VALUES (360, 74, 46, '2018-05-24 20:52:45', '3973de07ddf9b8f1379a7f3edcb78e43c029d9dbff622034037152a889');
INSERT INTO `msg` VALUES (366, 53, 44, '2019-09-06 19:28:56', '6f89bc580673bd8ca5d5cd083279c25ff78');
INSERT INTO `msg` VALUES (367, 72, 89, '2019-04-02 11:12:38', '88b599d1121a10ce4a18204f1521ccac3ff4cde7');
INSERT INTO `msg` VALUES (369, 58, 93, '2018-05-19 23:00:05', 'dac3db20310b7567b30b63b8827d131586c4d28b8a44624f2876');
INSERT INTO `msg` VALUES (371, 80, 72, '2018-08-01 09:50:03', '9239c59e2838ce1c0697cd0ee134c212eda495fc75f6eb4e');
INSERT INTO `msg` VALUES (372, 93, 73, '2018-08-01 09:50:03', '9239c59e2838ce1c0697cd0ee134c212eda495fc75f6eb4e');
INSERT INTO `msg` VALUES (373, 51, 52, '2018-12-09 13:56:01', '481613e152990444b76cd4b70ff15e3fe383f454bd563');
INSERT INTO `msg` VALUES (374, 36, 90, '2019-04-22 20:04:50', '4fb8ef976baff94de2796d2c7c9db0e932c3a6e445bfe87');
INSERT INTO `msg` VALUES (375, 83, 72, '2018-05-20 07:36:02', '0ee733a7a6334b9dccbb1ca89f210f889888df5e304afe5dc9ce4982c6');
INSERT INTO `msg` VALUES (378, 76, 53, '2018-05-15 06:55:47', 'e41002aaeff9');
INSERT INTO `msg` VALUES (379, 59, 75, '2019-05-12 17:34:37', '13b6481c1f07118313c565fa581e5463dcc9');
INSERT INTO `msg` VALUES (381, 45, 47, '2018-04-04 19:37:45', '2c2058fd29ec7e0dad731ff8a6a3e15325f64a819b79d1f77c593be92a805');
INSERT INTO `msg` VALUES (384, 80, 41, '2018-12-13 08:30:26', 'adfaa8aff0f7d4e0a4d9');
INSERT INTO `msg` VALUES (386, 79, 37, '2019-01-05 17:07:29', '0f43de5dd5cd99857d54');
INSERT INTO `msg` VALUES (391, 72, 50, '2019-01-16 14:19:51', '9f2cb1455a4b7abd8dcf6137487ec69dd9273d4113675cb22');
INSERT INTO `msg` VALUES (394, 93, 42, '2018-07-12 11:08:20', '8fe1cab76276fb3312f31bc09997625d970291f8');
INSERT INTO `msg` VALUES (396, 90, 51, '2019-09-04 13:22:12', '810f058db1f2c0f9cb7625d85317c7445c4714a03d71c1');
INSERT INTO `msg` VALUES (397, 59, 51, '2018-08-20 11:17:04', '810f058db1f2c0f9cb7625d85317c7445c4714a03d71c1');
INSERT INTO `msg` VALUES (398, 41, 89, '2018-08-20 11:17:04', 'f0f599554ca9bba8c32cf59c13e3ef922757878363b20ce8ea2f705c083d37');
INSERT INTO `msg` VALUES (400, 67, 76, '2018-01-03 03:32:16', '5e017786eed31ce947b7840955ef8ef1d963ba9cd268535a1');
INSERT INTO `msg` VALUES (401, 93, 85, '2019-03-15 17:16:09', 'cbf1a6c91f93626b5d7e77ec68871f61ecac1e6');
INSERT INTO `msg` VALUES (403, 46, 44, '2018-06-25 19:38:44', '455d616560e23125418bbba11');
INSERT INTO `msg` VALUES (407, 47, 79, '2019-12-05 19:34:29', 'bdc455854e88e2c');
INSERT INTO `msg` VALUES (408, 60, 80, '2019-03-25 15:38:20', 'bdc455854e88e2c');
INSERT INTO `msg` VALUES (409, 35, 76, '2018-06-24 15:51:18', '747a34c887da18ab415cef332ce6');
INSERT INTO `msg` VALUES (412, 59, 79, '2018-09-15 08:09:46', 'cc1bc01b536d1a15b2d');
INSERT INTO `msg` VALUES (414, 92, 52, '2018-07-17 03:02:43', '54a02869c1b0cdc13fc5443cc5b6271e08d912');
INSERT INTO `msg` VALUES (417, 67, 94, '2018-05-10 12:32:08', '9056e8318f574c85e195f87f5f957bbad030');
INSERT INTO `msg` VALUES (418, 91, 80, '2019-02-21 03:30:10', '300cf1410227d0a53293243cb08c63b6c65279d4ea39fe4a7e2a109de4d6');
INSERT INTO `msg` VALUES (419, 48, 40, '2019-03-07 12:56:06', '8cae6d18ada543aac2ed104c2dd769ae760bc3b9e0e3b');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NULL DEFAULT NULL,
  `senderId` int(11) NULL DEFAULT NULL,
  `replyTo` int(11) NULL DEFAULT NULL,
  `replyTime` datetime(0) NULL DEFAULT NULL,
  `replyText` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `reply_course_id_fk`(`courseId`) USING BTREE,
  INDEX `reply_reply_id_fk`(`replyTo`) USING BTREE,
  INDEX `reply_user_id_fk`(`senderId`) USING BTREE,
  CONSTRAINT `reply_course_id_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `reply_reply_id_fk` FOREIGN KEY (`replyTo`) REFERENCES `reply` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `reply_user_id_fk` FOREIGN KEY (`senderId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (3, 48, 1, 13, '2016-03-16 03:08:16', 'Auto generated 914');
INSERT INTO `reply` VALUES (7, 51, 1, 16, '2015-04-13 04:36:29', 'manually edited 01');
INSERT INTO `reply` VALUES (9, 52, 1, 3, '2016-10-24 15:46:55', 'Auto generated 296');
INSERT INTO `reply` VALUES (13, 52, 8, 7, '2017-08-01 07:24:10', 'Auto generated 628');
INSERT INTO `reply` VALUES (16, 49, 1, 24, '2015-01-19 22:55:43', 'Auto generated 883');
INSERT INTO `reply` VALUES (24, 32, 8, 9, '2017-08-08 08:57:45', 'Auto generated 874');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userId` int(11) NULL DEFAULT NULL,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `school` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `major` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `student_idNo_uindex`(`account`) USING BTREE,
  INDEX `student_user_id_fk`(`userId`) USING BTREE,
  CONSTRAINT `student_user_id_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '20172270607', 'f45c051f837695fcce85db873b5f123d', NULL, 'Student965', 'AutoSchool957', 'AutoMajor719');
INSERT INTO `student` VALUES (2, '20174675161', '8009a83a14f30d0e60d1159509d14319', NULL, 'Student293', 'AutoSchool548', 'AutoMajor523');
INSERT INTO `student` VALUES (3, '20182924543', '96ac64fab72f38965461763467219e94', NULL, 'Student572', 'AutoSchool576', 'AutoMajor357');
INSERT INTO `student` VALUES (4, '20152244943', '00adfd25ca063c31315be72a1e2110ff', NULL, 'Student980', 'AutoSchool386', 'AutoMajor802');
INSERT INTO `student` VALUES (5, '20188604741', '3963487de040f3677dd523f7a9f293f2', NULL, 'Student186', 'AutoSchool404', 'AutoMajor643');
INSERT INTO `student` VALUES (6, '20150949459', '58913d4949159946ac7a6160bb374934', NULL, 'Student989', 'AutoSchool682', 'AutoMajor375');
INSERT INTO `student` VALUES (7, '20180195610', 'ef4489ab6d8ae3dc46ac1f52c8dd3607', NULL, 'Student386', 'AutoSchool145', 'AutoMajor741');
INSERT INTO `student` VALUES (8, '20161272825', 'f2fef1c2b29913b3cd05a48c3aaa1826', NULL, 'Student967', 'AutoSchool248', 'AutoMajor6');
INSERT INTO `student` VALUES (9, '20164223246', '7868b38369d0280e3167f82f3adb9eb1', NULL, 'Student675', 'AutoSchool89', 'AutoMajor549');
INSERT INTO `student` VALUES (10, '20167525321', 'c110c190641de2814e83408f8227e716', NULL, 'Student474', 'AutoSchool788', 'AutoMajor890');
INSERT INTO `student` VALUES (11, '20157713590', '44d286042a60874c9f1faecf358cb02a', NULL, 'Student346', 'AutoSchool412', 'AutoMajor153');
INSERT INTO `student` VALUES (12, '20171941377', '6b0fa5b4eb2474f2fc1b6d3b0f90b8cc', NULL, 'Student311', 'AutoSchool387', 'AutoMajor24');
INSERT INTO `student` VALUES (13, '20187271755', '110127cd007bddf0049aa105b0eac309', NULL, 'Student514', 'AutoSchool718', 'AutoMajor800');
INSERT INTO `student` VALUES (14, '20188360637', 'de7f51f605d243684d4c4acabe3be3e9', NULL, 'Student638', 'AutoSchool484', 'AutoMajor384');
INSERT INTO `student` VALUES (15, '20161860526', 'f987c8fac6c619a8d1b86bc5a7c3c099', NULL, 'Student650', 'AutoSchool801', 'AutoMajor778');
INSERT INTO `student` VALUES (16, '20161106084', 'b1f3e8adc8fb425f85d0d8421fea57d6', NULL, 'Student337', 'AutoSchool206', 'AutoMajor756');
INSERT INTO `student` VALUES (17, '20155392211', 'dd8995f1a46d663d4d28d0e91a524e38', NULL, 'Student735', 'AutoSchool558', 'AutoMajor478');
INSERT INTO `student` VALUES (18, '20171384548', '1ebeb7aa4a92c117252dd1a2e121e422', NULL, 'Student666', 'AutoSchool993', 'AutoMajor983');
INSERT INTO `student` VALUES (19, '20187336858', '0b0b12cb28ce2dbf3a4711fdfe4860b9', NULL, 'Student125', 'AutoSchool872', 'AutoMajor94');
INSERT INTO `student` VALUES (20, '20189825354', 'aa52ca4574fda31c747c10e7bea5c403', NULL, 'Student627', 'AutoSchool49', 'AutoMajor781');
INSERT INTO `student` VALUES (21, '20184534987', '997bda7c9b08fa342b169b4212f5409a', NULL, 'Student761', 'AutoSchool931', 'AutoMajor920');
INSERT INTO `student` VALUES (22, '20182699931', '4b47e4ec8b27b1c0f380ad4c202f1651', NULL, 'Student924', 'AutoSchool450', 'AutoMajor705');
INSERT INTO `student` VALUES (23, '20157672305', '9ea6d9e74408bbcc33c0a947397aa87f', NULL, 'Student337', 'AutoSchool210', 'AutoMajor377');
INSERT INTO `student` VALUES (24, '20161432950', 'e49e1d04c2d981fdbcb7df304396388d', NULL, 'Student914', 'AutoSchool769', 'AutoMajor872');
INSERT INTO `student` VALUES (25, '20156587127', '1a3a511a070a9eebe0ee1970d14cd589', NULL, 'Student557', 'AutoSchool933', 'AutoMajor675');
INSERT INTO `student` VALUES (26, '20178710615', '33d05761cef0723a3514d8901e0d4c41', NULL, 'Student47', 'AutoSchool486', 'AutoMajor30');
INSERT INTO `student` VALUES (27, '20173760799', 'f36e0e15b3a121a2794c8c931e2fe148', NULL, 'Student562', 'AutoSchool953', 'AutoMajor156');
INSERT INTO `student` VALUES (28, '20181367920', 'c7b57b5078c595c7a0e065688fc10356', NULL, 'Student671', 'AutoSchool192', 'AutoMajor388');
INSERT INTO `student` VALUES (29, '20166743266', '5c18955307517bb99c60e4378b07c902', NULL, 'Student670', 'AutoSchool759', 'AutoMajor859');
INSERT INTO `student` VALUES (30, '20155270571', 'c83a1de868561eb6e9a41266a9bf7321', NULL, 'Student338', 'AutoSchool665', 'AutoMajor499');
INSERT INTO `student` VALUES (31, '20160020510', 'b0b80ee7fce9bab8a3a9068e1c5c85ad', NULL, 'Student680', 'AutoSchool197', 'AutoMajor351');
INSERT INTO `student` VALUES (32, '20157739371', '660589eb3aa9453ee8fcbfae30a79115', NULL, 'Student388', 'AutoSchool574', 'AutoMajor258');
INSERT INTO `student` VALUES (33, '20170592596', 'd1194e90fc63290e743dd0831f2a7093', NULL, 'Student900', 'AutoSchool231', 'AutoMajor743');
INSERT INTO `student` VALUES (34, '20158964405', 'e364970686f31865333fd6d0614aff1f', NULL, 'Student336', 'AutoSchool473', 'AutoMajor352');
INSERT INTO `student` VALUES (35, '20166611274', '9d94da8a44b8a4e2bf959b8d89368255', NULL, 'Student982', 'AutoSchool116', 'AutoMajor418');
INSERT INTO `student` VALUES (36, '20174520036', '0b8b8dda5afae44164178041d83b00ca', NULL, 'Student900', 'AutoSchool26', 'AutoMajor648');
INSERT INTO `student` VALUES (37, '20158856928', 'ae016173ad4f5b43aeafac3a8aeef571', NULL, 'Student557', 'AutoSchool145', 'AutoMajor769');
INSERT INTO `student` VALUES (38, '20167353451', 'a98dbc61fbe82ec79b3efcf3ff59ff3b', NULL, 'Student85', 'AutoSchool899', 'AutoMajor344');
INSERT INTO `student` VALUES (39, '20150806335', '03050ecf7e6a6080f8e5b39bbe805b6a', NULL, 'Student755', 'AutoSchool173', 'AutoMajor559');
INSERT INTO `student` VALUES (40, '20167060699', '98755937dcf47e44449b61b6b025a1f5', NULL, 'Student519', 'AutoSchool795', 'AutoMajor842');
INSERT INTO `student` VALUES (41, '20185900480', 'c47160310af995684084f82416432ce0', NULL, 'Student331', 'AutoSchool722', 'AutoMajor712');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NULL DEFAULT NULL,
  `courseId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_course_course_id_fk`(`courseId`) USING BTREE,
  INDEX `student_course_student_id_fk`(`studentId`) USING BTREE,
  CONSTRAINT `student_course_course_id_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `student_course_student_id_fk` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES (3, 32, 20);
INSERT INTO `student_course` VALUES (4, 3, 34);
INSERT INTO `student_course` VALUES (5, 8, 40);
INSERT INTO `student_course` VALUES (7, 19, 51);
INSERT INTO `student_course` VALUES (8, 6, 44);
INSERT INTO `student_course` VALUES (9, 26, 20);
INSERT INTO `student_course` VALUES (10, 21, 51);
INSERT INTO `student_course` VALUES (12, 1, 54);
INSERT INTO `student_course` VALUES (13, 27, 72);
INSERT INTO `student_course` VALUES (15, 22, 22);
INSERT INTO `student_course` VALUES (17, 2, 43);
INSERT INTO `student_course` VALUES (18, 35, 30);
INSERT INTO `student_course` VALUES (20, 1, 33);
INSERT INTO `student_course` VALUES (21, 11, 62);
INSERT INTO `student_course` VALUES (22, 22, 7);
INSERT INTO `student_course` VALUES (23, 36, 7);
INSERT INTO `student_course` VALUES (27, 9, 53);
INSERT INTO `student_course` VALUES (28, 1, 61);
INSERT INTO `student_course` VALUES (29, 10, 41);
INSERT INTO `student_course` VALUES (30, 7, 10);
INSERT INTO `student_course` VALUES (32, 21, 24);
INSERT INTO `student_course` VALUES (33, 5, 41);
INSERT INTO `student_course` VALUES (34, 20, 50);
INSERT INTO `student_course` VALUES (36, 12, 12);
INSERT INTO `student_course` VALUES (38, 23, 18);
INSERT INTO `student_course` VALUES (40, 20, 20);
INSERT INTO `student_course` VALUES (41, 40, 72);
INSERT INTO `student_course` VALUES (42, 4, 34);
INSERT INTO `student_course` VALUES (47, 6, 65);
INSERT INTO `student_course` VALUES (48, 5, 64);
INSERT INTO `student_course` VALUES (50, 21, 71);
INSERT INTO `student_course` VALUES (51, 16, 65);
INSERT INTO `student_course` VALUES (52, 17, 26);
INSERT INTO `student_course` VALUES (54, 3, 51);
INSERT INTO `student_course` VALUES (56, 35, 41);
INSERT INTO `student_course` VALUES (58, 30, 10);
INSERT INTO `student_course` VALUES (59, 21, 10);
INSERT INTO `student_course` VALUES (60, 6, 24);
INSERT INTO `student_course` VALUES (63, 11, 19);
INSERT INTO `student_course` VALUES (66, 13, 4);
INSERT INTO `student_course` VALUES (69, 12, 21);
INSERT INTO `student_course` VALUES (70, 22, 71);
INSERT INTO `student_course` VALUES (71, 23, 27);
INSERT INTO `student_course` VALUES (72, 3, 19);
INSERT INTO `student_course` VALUES (73, 5, 24);
INSERT INTO `student_course` VALUES (74, 18, 7);
INSERT INTO `student_course` VALUES (75, 30, 7);
INSERT INTO `student_course` VALUES (76, 1, 27);
INSERT INTO `student_course` VALUES (77, 36, 26);
INSERT INTO `student_course` VALUES (78, 5, 54);
INSERT INTO `student_course` VALUES (79, 37, 18);
INSERT INTO `student_course` VALUES (80, 5, 71);
INSERT INTO `student_course` VALUES (81, 15, 47);
INSERT INTO `student_course` VALUES (82, 16, 54);
INSERT INTO `student_course` VALUES (83, 9, 54);
INSERT INTO `student_course` VALUES (84, 33, 24);
INSERT INTO `student_course` VALUES (85, 1, 30);
INSERT INTO `student_course` VALUES (86, 6, 10);
INSERT INTO `student_course` VALUES (87, 37, 48);
INSERT INTO `student_course` VALUES (88, 18, 4);
INSERT INTO `student_course` VALUES (89, 36, 43);
INSERT INTO `student_course` VALUES (90, 32, 61);
INSERT INTO `student_course` VALUES (91, 38, 7);
INSERT INTO `student_course` VALUES (92, 9, 21);
INSERT INTO `student_course` VALUES (93, 2, 31);
INSERT INTO `student_course` VALUES (94, 23, 7);
INSERT INTO `student_course` VALUES (95, 40, 34);
INSERT INTO `student_course` VALUES (96, 2, 72);
INSERT INTO `student_course` VALUES (97, 30, 66);
INSERT INTO `student_course` VALUES (98, 34, 19);
INSERT INTO `student_course` VALUES (99, 18, 12);
INSERT INTO `student_course` VALUES (100, 3, 61);
INSERT INTO `student_course` VALUES (101, 29, 12);
INSERT INTO `student_course` VALUES (102, 37, 52);
INSERT INTO `student_course` VALUES (103, 19, 43);
INSERT INTO `student_course` VALUES (104, 18, 21);
INSERT INTO `student_course` VALUES (105, 16, 47);
INSERT INTO `student_course` VALUES (106, 33, 31);
INSERT INTO `student_course` VALUES (107, 20, 21);
INSERT INTO `student_course` VALUES (108, 24, 20);
INSERT INTO `student_course` VALUES (109, 22, 61);
INSERT INTO `student_course` VALUES (110, 4, 51);
INSERT INTO `student_course` VALUES (111, 4, 33);
INSERT INTO `student_course` VALUES (112, 4, 36);
INSERT INTO `student_course` VALUES (113, 29, 22);
INSERT INTO `student_course` VALUES (114, 13, 50);
INSERT INTO `student_course` VALUES (115, 27, 68);
INSERT INTO `student_course` VALUES (116, 20, 53);
INSERT INTO `student_course` VALUES (117, 28, 43);
INSERT INTO `student_course` VALUES (118, 7, 60);
INSERT INTO `student_course` VALUES (119, 26, 7);
INSERT INTO `student_course` VALUES (120, 39, 50);
INSERT INTO `student_course` VALUES (121, 3, 60);
INSERT INTO `student_course` VALUES (122, 32, 50);
INSERT INTO `student_course` VALUES (123, 30, 44);
INSERT INTO `student_course` VALUES (124, 15, 22);
INSERT INTO `student_course` VALUES (125, 11, 12);
INSERT INTO `student_course` VALUES (126, 30, 64);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userId` int(11) NULL DEFAULT NULL,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `school` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `major` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `teacher_idNo_uindex`(`account`) USING BTREE,
  INDEX `teacher_user_id_fk`(`userId`) USING BTREE,
  CONSTRAINT `teacher_user_id_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '12028332984', 'fcf40f8ff5ed7cc43d37b9bcc27d38f2', NULL, 'Teacher240', 'AutoSchool164', 'AutoMajor551');
INSERT INTO `teacher` VALUES (2, '12026579503', '14d78fc1c85595d30b0e9641b3acb994', NULL, 'Teacher468', 'AutoSchool198', 'AutoMajor366');
INSERT INTO `teacher` VALUES (3, '12010980771', '8e77f966f5e1a49894d76a58d7b9dc3a', NULL, 'Teacher618', 'AutoSchool491', 'AutoMajor775');
INSERT INTO `teacher` VALUES (4, '12026804198', '376616f9d6d94989a3ef44a751fcbd66', NULL, 'Teacher688', 'AutoSchool161', 'AutoMajor951');
INSERT INTO `teacher` VALUES (5, '12025204776', 'c00cab35160c6c73693cb73d2bf99751', NULL, 'Teacher584', 'AutoSchool280', 'AutoMajor438');
INSERT INTO `teacher` VALUES (6, '12024283095', '18e9f6d2ea59f61f60e538d98567357f', NULL, 'Teacher860', 'AutoSchool684', 'AutoMajor838');
INSERT INTO `teacher` VALUES (7, '12011908529', '0cd99e54be2df3aa646224ca62e84d12', NULL, 'Teacher547', 'AutoSchool784', 'AutoMajor696');
INSERT INTO `teacher` VALUES (8, '12015724464', 'c7a9f475c3fea96059074404877a274e', NULL, 'Teacher156', 'AutoSchool626', 'AutoMajor319');
INSERT INTO `teacher` VALUES (9, '12036350019', 'c42937d4cdd4e7924f2803d9c31bb957', NULL, 'Teacher137', 'AutoSchool900', 'AutoMajor927');
INSERT INTO `teacher` VALUES (10, '12048911652', '355d8bb9acbfc9b6c4f791333dbf8ecc', NULL, 'Teacher220', 'AutoSchool980', 'AutoMajor139');
INSERT INTO `teacher` VALUES (11, '12043609537', '30e5d85a58a6aadd518bd2f06ad54a7a', NULL, 'Teacher688', 'AutoSchool405', 'AutoMajor215');
INSERT INTO `teacher` VALUES (12, '12046578707', '45783497befbc6fec52494bbb19dc72b', NULL, 'Teacher781', 'AutoSchool693', 'AutoMajor779');
INSERT INTO `teacher` VALUES (13, '12047486290', 'ea080063334e7ffad424dd8746651623', NULL, 'Teacher842', 'AutoSchool160', 'AutoMajor184');
INSERT INTO `teacher` VALUES (14, '12026434899', 'c0a183f5e672244230285a1d0aa89ea0', NULL, 'Teacher867', 'AutoSchool135', 'AutoMajor977');
INSERT INTO `teacher` VALUES (15, '12024706911', '4142739507c645fab649c64b94f6caab', NULL, 'Teacher809', 'AutoSchool995', 'AutoMajor537');
INSERT INTO `teacher` VALUES (16, '12038942367', '10ffd5525e64fc60ae926711685f5009', NULL, 'Teacher446', 'AutoSchool670', 'AutoMajor889');
INSERT INTO `teacher` VALUES (17, '12025006202', '083a3f6ec5b35084fe7cee6f2beb364b', NULL, 'Teacher804', 'AutoSchool944', 'AutoMajor193');
INSERT INTO `teacher` VALUES (18, '12010803005', '8b2d841ea59830c1db9de51558b78d88', NULL, 'Teacher682', 'AutoSchool910', 'AutoMajor196');
INSERT INTO `teacher` VALUES (19, '12026703595', 'd2e6562bec62ba85ce20ddf7930af0b4', NULL, 'Teacher998', 'AutoSchool48', 'AutoMajor339');
INSERT INTO `teacher` VALUES (20, '12037472076', '4307d254bb2934a537edeaa91b66aaea', NULL, 'Teacher943', 'AutoSchool478', 'AutoMajor965');
INSERT INTO `teacher` VALUES (21, '12020781205', 'b1cc401e37df2822854041dcaeceb4ba', NULL, 'Teacher724', 'AutoSchool340', 'AutoMajor326');
INSERT INTO `teacher` VALUES (22, '12030929620', '2f77df9ddde1b2f5129ad432fd945840', NULL, 'Teacher791', 'AutoSchool255', 'AutoMajor807');
INSERT INTO `teacher` VALUES (23, '12029347859', '5978deefe0afd30ef30120379bf5f0fa', NULL, 'Teacher784', 'AutoSchool880', 'AutoMajor926');
INSERT INTO `teacher` VALUES (24, '12041732895', '65df6d4818e89e29194816fc95b561f0', NULL, 'Teacher546', 'AutoSchool97', 'AutoMajor616');
INSERT INTO `teacher` VALUES (25, '12041072161', '96f51966af5ab5982411344896b5cbee', NULL, 'Teacher379', 'AutoSchool952', 'AutoMajor297');
INSERT INTO `teacher` VALUES (26, '12032739469', '3ab954de1ab816e3986b2f25fcfed20a', NULL, 'Teacher259', 'AutoSchool212', 'AutoMajor489');
INSERT INTO `teacher` VALUES (27, '12045769458', '14a28e6f58a97038b7dda6704250abb9', NULL, 'Teacher159', 'AutoSchool426', 'AutoMajor451');
INSERT INTO `teacher` VALUES (28, '12045302720', 'c9516b1c608b72898d91c50d546becb8', NULL, 'Teacher16', 'AutoSchool905', 'AutoMajor486');
INSERT INTO `teacher` VALUES (29, '12031285489', 'f568f728c382dfff04a7c0fea5b51d1a', NULL, 'Teacher606', 'AutoSchool830', 'AutoMajor975');
INSERT INTO `teacher` VALUES (30, '12029991840', '81f86edb34ae38cbb8090f856883dd0e', NULL, 'Teacher981', 'AutoSchool499', 'AutoMajor887');
INSERT INTO `teacher` VALUES (31, '12040212296', '2784edfa4791e6f9bc7d2ed73eabbd7d', NULL, 'Teacher87', 'AutoSchool198', 'AutoMajor740');
INSERT INTO `teacher` VALUES (32, '12013105233', 'eeeaaca9db80cd6c6e8a140f29818cf9', NULL, 'Teacher491', 'AutoSchool482', 'AutoMajor703');
INSERT INTO `teacher` VALUES (33, '12012295944', '4ffdfab45786a5004a3f93e75b133979', NULL, 'Teacher197', 'AutoSchool328', 'AutoMajor544');
INSERT INTO `teacher` VALUES (34, '12030567069', '3aa966f3cbb143b2f7c419b4ae4b4b98', NULL, 'Teacher511', 'AutoSchool678', 'AutoMajor858');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT 1,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_email_uindex`(`email`) USING BTREE,
  UNIQUE INDEX `user_username_uindex`(`username`) USING BTREE,
  INDEX `user_user_type_type_fk`(`type`) USING BTREE,
  CONSTRAINT `user_user_type_type_fk` FOREIGN KEY (`type`) REFERENCES `user_type` (`type`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 132 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '', 1, 'newUser', 'newuser@abc.com', 'f6796a59fad7e918dbad2ac644bf8a95', 'Newbee');
INSERT INTO `user` VALUES (8, '', 1, '?????', 'demouser@abc.com', '2acc3bf71d34ac22557e0ab54acc5be3', 'abc');
INSERT INTO `user` VALUES (34, '', 1, 'newreged', 'newreged@qq.com', 'f7483ecfd9e1ab2050fe222ba932d7b1', 'abc');
INSERT INTO `user` VALUES (35, '', 1, 'qwerty', 'qwerty@abc.com', '9d1ed195075bd07061b9200ea8e4ff39', 'abc');
INSERT INTO `user` VALUES (36, '', 2, 'newuserabc', 'newuserabc@abc.com', 'd6514a9eb77d4b10ae6aea6019877ee6', 'abc');
INSERT INTO `user` VALUES (37, '', 1, 'newreged2', 'newreged2@www.com', '33d3cde59f37c1587fb45c150dd1e8a9', '');
INSERT INTO `user` VALUES (40, '', 0, 'manuallyUsername17', '412616148@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 1233');
INSERT INTO `user` VALUES (41, '', 1, 'manuallyUsername56', '692699563@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 1724');
INSERT INTO `user` VALUES (42, '', 1, 'newuserabc2', 'newuserabc2@abc.com', 'bc7e1d96b390a9508cb018836f568b46', '???????');
INSERT INTO `user` VALUES (43, '', 0, 'manuallyUsername49', '85546325@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 918');
INSERT INTO `user` VALUES (44, '', 1, 'manuallyAdded1', 'manually1@abc.com', 'bd2f83b76fd520e13878f411f461674c', '');
INSERT INTO `user` VALUES (45, '', 1, 'manuallyUsername76', '6852854@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 244');
INSERT INTO `user` VALUES (46, '', 1, 'manuallyUsername98', '166307375@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 7184');
INSERT INTO `user` VALUES (47, '', 0, 'manuallyUsername91', '179705012@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 4550');
INSERT INTO `user` VALUES (48, '', 2, 'manuallyUsername75', '651341287@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 3110');
INSERT INTO `user` VALUES (49, '', 2, 'manuallyUsername84', '568706546@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 425');
INSERT INTO `user` VALUES (50, '', 1, 'manuallyUsername38', '376747357@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 3119');
INSERT INTO `user` VALUES (51, '', 2, 'manuallyUsername57', '187818407@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 4254');
INSERT INTO `user` VALUES (52, '', 0, 'manuallyUsername96', '560916132@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 2295');
INSERT INTO `user` VALUES (53, '', 1, 'manuallyUsername9', '746836517@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 99');
INSERT INTO `user` VALUES (54, '', 1, 'manuallyUsername54', '537287046@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 8491');
INSERT INTO `user` VALUES (55, '', 2, 'manuallyUsername88', '857602783@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 6767');
INSERT INTO `user` VALUES (57, '', 2, 'manuallyUsername85', '590877593@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 5563');
INSERT INTO `user` VALUES (58, '', 1, 'manuallyUsername3', '600165991@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 1321');
INSERT INTO `user` VALUES (59, '', 2, 'manuallyUsername93', '836563276@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 1789');
INSERT INTO `user` VALUES (60, '', 1, 'manuallyUsername46', '654228063@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 7622');
INSERT INTO `user` VALUES (66, '', 0, 'manuallyUsername27', '126720484@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 2304');
INSERT INTO `user` VALUES (67, '', 1, 'manuallyUsername74', '520566892@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 8262');
INSERT INTO `user` VALUES (72, '', 1, 'manuallyUsername81', '414087465@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 1040');
INSERT INTO `user` VALUES (73, '', 0, 'manuallyUsername59', '477515738@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 8382');
INSERT INTO `user` VALUES (74, '', 2, 'manuallyUsername92', '777308411@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 5276');
INSERT INTO `user` VALUES (75, '', 0, 'manuallyUsername5', '740281688@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 5217');
INSERT INTO `user` VALUES (76, '', 2, 'manuallyUsername23', '254142022@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 4547');
INSERT INTO `user` VALUES (78, '', 1, 'manuallyUsername48', '660783743@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 8790');
INSERT INTO `user` VALUES (79, '', 0, 'manuallyUsername51', '823388945@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 5016');
INSERT INTO `user` VALUES (80, '', 2, 'manuallyUsername11', '27509648@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 2101');
INSERT INTO `user` VALUES (83, '', 0, 'manuallyUsername25', '145135015@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 1751');
INSERT INTO `user` VALUES (85, '', 1, 'manuallyUsername64', '263034589@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 4315');
INSERT INTO `user` VALUES (89, '', 2, 'manuallyUsername80', '179011057@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 3635');
INSERT INTO `user` VALUES (90, '', 1, 'manuallyUsername50', '902910045@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 553');
INSERT INTO `user` VALUES (91, '', 2, 'manuallyUsername31', '51968908@manual.com', '14a88b9d2f52c55b5fbcf9c5d9c11875', 'Manually added user 4178');
INSERT INTO `user` VALUES (92, '', 1, '?????01', 'newregeduser01@abc.com', '28dde4a5a7c77be95b69170984979f14', '');
INSERT INTO `user` VALUES (93, '', 1, '????02', 'manualluuser02@abc.com', 'a84bee75c869739f19b40f781f86ec48', '');
INSERT INTO `user` VALUES (94, '', 1, 'newuser28023', 'newuser28023@abc.com', '339bd4e88c2d75aaaf8f28c4e164e0f3', '');
INSERT INTO `user` VALUES (95, '', 1, 'RandomUser384', 'randomEmail@6947.com', 'f2649c14668a1cd15a9ad81314e4a6fe', 'Random Added User 5937');
INSERT INTO `user` VALUES (96, '', 1, 'RandomUser4000', 'randomEmail@5177.com', '2a7bd8ffc3b4160ac6658d030407301d', 'Random Added User 2823');
INSERT INTO `user` VALUES (97, '', 1, 'RandomUser2524', 'randomEmail@238.com', 'd8274a8360040372f95ea3e9c3007cef', 'Random Added User 527');
INSERT INTO `user` VALUES (98, '', 1, 'RandomUser290', 'randomEmail@5808.com', '8ba6d2d2c41353ae4235913acf9c6baa', 'Random Added User 9444');
INSERT INTO `user` VALUES (99, '', 1, 'RandomUser5770', 'randomEmail@4365.com', 'e4932ed2b31e531ac2623ca6aa531c70', 'Random Added User 3337');
INSERT INTO `user` VALUES (100, '', 1, 'RandomUser3468', 'randomEmail@808.com', 'bd45395f61e9ce8904dd8570751b0d17', 'Random Added User 272');
INSERT INTO `user` VALUES (101, '', 1, 'RandomUser7530', 'randomEmail@5131.com', '4bc81184c8a32060c2dd46c36b2d20af', 'Random Added User 6036');
INSERT INTO `user` VALUES (102, '', 1, 'RandomUser8093', 'randomEmail@8830.com', 'aa94457612fa46cc6d467a350187daa3', 'Random Added User 4447');
INSERT INTO `user` VALUES (103, '', 1, 'RandomUser7954', 'randomEmail@9284.com', 'fef6421269a5c3dc19036db1ed747c36', 'Random Added User 9472');
INSERT INTO `user` VALUES (104, '', 1, 'RandomUser150', 'randomEmail@5085.com', '77c1d2a7c2a1cd5bb77fd42ad2bd3c44', 'Random Added User 5470');
INSERT INTO `user` VALUES (105, '', 1, 'RandomUser7105', 'randomEmail@1995.com', 'e3e49929548885bce93ab7ae378a54ab', 'Random Added User 7647');
INSERT INTO `user` VALUES (106, '', 1, 'RandomUser8975', 'randomEmail@9711.com', '51e96001925cf2b90081c84b144c5094', 'Random Added User 3194');
INSERT INTO `user` VALUES (107, '', 1, 'newuser28024', 'newuser28024@abc.com', '9f9ed0340bce07ff64ac9898b0dee200', '');
INSERT INTO `user` VALUES (108, '', 1, 'RandomUser7575', 'randomEmail@1356.com', '9b118248fe1819f6b6de831d33a5885f', 'Random Added User 3450');
INSERT INTO `user` VALUES (109, '', 1, 'newuser28025', 'newuser28025@abc.com', '7651aa320e616d0664d70ff1550e92aa', '');
INSERT INTO `user` VALUES (110, 'D32ABC2E7492A55079C16DB780AF72DC', 0, 'newuser28028', 'newuser28028@qq.com', 'd1c00038a41c5575c7c64bb2c7dfc380', '');
INSERT INTO `user` VALUES (111, NULL, 1, 'RandomUser8119', 'randomEmail@7650.com', 'd610d5d3ecd5d19020668640c6ccde86', 'Random Added User 6564');
INSERT INTO `user` VALUES (114, 'CC724E931923E93527391CC4BEF6372A', 1, 'abcabc', 'abcabc@abc.com', '2acc3bf71d34ac22557e0ab54acc5be3', 'manually added');
INSERT INTO `user` VALUES (115, '7DB8DCB9B71FC5BC0BB5CFA028ADA98C', 1, 'imnewbie', 'imnewbie@abc.com', 'afc11164ff21a07b559b2d72c518c360', '');
INSERT INTO `user` VALUES (116, '5D587C74F4EDA8D5E9E1EFA6A3D42FEE', 1, 'newbie02', 'newbiew02@abc.com', '02b097a189c8e72d6370eee4c4f1c3aa', '');
INSERT INTO `user` VALUES (117, NULL, 2, 'newuser02', 'newuser02@abc.com', 'ab3f5ae7e6e599bd6be2a68c00f36ec3', 'Manually added `newuser02`');
INSERT INTO `user` VALUES (118, '8C475434A0D7C48D1D8C9A88A05DC8EA', 1, 'newuser03', 'newuser03@abc.com', '6720888688bd554b46267d3cdafc847b', '');
INSERT INTO `user` VALUES (121, '3701912B4EAF11CFD42B6BF3FA6E3404', 0, 'admin01', 'admin01@abc.com', '87f3de29d804e79de57f9ad2830f2c27', NULL);
INSERT INTO `user` VALUES (122, '', 0, 'admin02', 'admin02@abc.com', '5487ec10a3e49e724071f68038895210', '');
INSERT INTO `user` VALUES (129, '69660418CCBB53A85C75E8E1A552B0B4', 0, '???03', 'admin03@abc.com', '8ced6fc8b7b711a2b0610629214edd25', '');
INSERT INTO `user` VALUES (130, '0e4d24ca67ed4361b795d1fedcf5e19a', 0, 'admin04', 'admin04@abc.com', 'ca8c0c3059eb8de878ae6320b1b9838d', '');
INSERT INTO `user` VALUES (131, 'e34f2328dca94695b2886149649901f2', 0, 'admin05', 'admin05@abc.com', 'af4dc7e5313510a25b5898a141810fc9', '');

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `typeName` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_type_type_uindex`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_type
-- ----------------------------
INSERT INTO `user_type` VALUES (1, 0, 'SuperUser');
INSERT INTO `user_type` VALUES (2, 1, '??');
INSERT INTO `user_type` VALUES (3, 2, '??');

SET FOREIGN_KEY_CHECKS = 1;
