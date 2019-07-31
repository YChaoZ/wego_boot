/*
 Navicat Premium Data Transfer

 Source Server         : yc
 Source Server Type    : PostgreSQL
 Source Server Version : 100001
 Source Host           : localhost:5432
 Source Catalog        : wego
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 100001
 File Encoding         : 65001

 Date: 12/12/2018 14:11:59
*/


-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS "public"."personal";
CREATE TABLE "public"."personal" (
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "sex" varchar(255) COLLATE "pg_catalog"."default",
  "idcard" varchar(255) COLLATE "pg_catalog"."default",
  "mobile" varchar(255) COLLATE "pg_catalog"."default",
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "work" varchar(255) COLLATE "pg_catalog"."default",
  "birthland" varchar(255) COLLATE "pg_catalog"."default",
  "locus" varchar(255) COLLATE "pg_catalog"."default",
  "company" varchar(255) COLLATE "pg_catalog"."default",
  "school" varchar(255) COLLATE "pg_catalog"."default",
  "autograph" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."personal"."name" IS '用户姓名';
COMMENT ON COLUMN "public"."personal"."sex" IS '性别';
COMMENT ON COLUMN "public"."personal"."idcard" IS '身份证';
COMMENT ON COLUMN "public"."personal"."mobile" IS '电话';
COMMENT ON COLUMN "public"."personal"."email" IS '邮箱';
COMMENT ON COLUMN "public"."personal"."work" IS '职业';
COMMENT ON COLUMN "public"."personal"."birthland" IS '故乡';
COMMENT ON COLUMN "public"."personal"."locus" IS '所在地';
COMMENT ON COLUMN "public"."personal"."company" IS '公司';
COMMENT ON COLUMN "public"."personal"."school" IS '学校';
COMMENT ON COLUMN "public"."personal"."autograph" IS '签名';

-- ----------------------------
-- Primary Key structure for table personal
-- ----------------------------
ALTER TABLE "public"."personal" ADD CONSTRAINT "PERSONAL_pkey" PRIMARY KEY ("name");
