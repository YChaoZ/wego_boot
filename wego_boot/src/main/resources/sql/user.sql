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

 Date: 12/12/2018 14:11:37
*/


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "salt" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;
COMMENT ON COLUMN "public"."user"."id" IS '用户ID';
COMMENT ON COLUMN "public"."user"."name" IS '用户名';
COMMENT ON COLUMN "public"."user"."password" IS '用户密码';
COMMENT ON COLUMN "public"."user"."salt" IS '盐值';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "public"."user" VALUES (1, 'YC', 'admin', '');

-- ----------------------------
-- Indexes structure for table user
-- ----------------------------
CREATE INDEX "IDX_USER" ON "public"."user" USING btree (
  "id" "pg_catalog"."int4_ops" ASC NULLS LAST,
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "USER_pkey" PRIMARY KEY ("id");
