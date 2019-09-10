/*==============================================================*/
/* Table: core_ads                                              */
/*==============================================================*/
create table core_ads
(
   ads_id               bigint not null auto_increment,
   title                varchar(100) not null comment '标题',
   sort                 int(5) not null default 1 comment '排序',
   link                 varchar(200) comment '链接地址',
   image_url            varchar(200) comment '图片地址',
   type                 int(2) not null default 1 comment '广告类型  1 首页轮播  2  开机动画',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (ads_id)
);

alter table core_ads comment '广告轮播';

/*==============================================================*/
/* Table: core_article                                          */
/*==============================================================*/
create table core_article
(
   article_id           bigint unsigned not null auto_increment,
   article_title        varchar(200) not null comment '文章标题',
   article_category_id  bigint unsigned not null comment '文章分类ID',
   type                 int(1) unsigned not null default 1 comment '文章类型  1  文章  2  图集',
   publish_time         datetime comment '发布时间',
   author_id            bigint unsigned comment '文章作者ID',
   author_name          varchar(20) comment '文章作者名称',
   read_count           bigint unsigned comment '阅读量',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (article_id)
);

alter table core_article comment '文章信息';

/*==============================================================*/
/* Table: core_article_category                                 */
/*==============================================================*/
create table core_article_category
(
   article_category_id  bigint unsigned not null auto_increment,
   article_category_name varchar(200) not null comment '文章分类标题',
   parent_category_id   bigint unsigned comment '父级分类ID',
   category_level       int(1) unsigned default 0 comment '分类等级 0 顶级 1 一级  暂时只支持到一级',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (article_category_id)
);

alter table core_article_category comment '文章分类';

/*==============================================================*/
/* Table: core_article_content                                  */
/*==============================================================*/
create table core_article_content
(
   content_id           bigint unsigned not null auto_increment,
   article_id           bigint unsigned not null,
   article_content      text comment '文章内容',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (content_id)
);

alter table core_article_content comment '文章内容';

/*==============================================================*/
/* Index: core_article_content_uk1                              */
/*==============================================================*/
create unique index core_article_content_uk1 on core_article_content
(
   article_id
);

/*==============================================================*/
/* Table: core_dept                                             */
/*==============================================================*/
create table core_dept
(
   dept_id              bigint unsigned not null auto_increment comment '部门id',
   parent_id            bigint comment '父部门id',
   dept_name            varchar(30) comment '部门名称',
   order_num            int(4) default 0 comment '显示顺序',
   leader               varchar(20) comment '负责人',
   level                int(1) default 0 comment '部门等级',
   phone                varchar(20) comment '联系电话',
   email                varchar(20) comment '邮箱',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (dept_id)
);

alter table core_dept comment '部门信息';

/*==============================================================*/
/* Table: core_dict_catalog                                     */
/*==============================================================*/
create table core_dict_catalog
(
   dict_id              bigint unsigned not null auto_increment,
   dict_name            varchar(100) not null comment '字典名称',
   dict_type            varchar(100) not null comment '字典类型',
   status               int(1) not null default 0 comment '状态（0正常 1禁用）',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (dict_id)
);

alter table core_dict_catalog comment '字典目录';

/*==============================================================*/
/* Table: core_dict_data                                        */
/*==============================================================*/
create table core_dict_data
(
   dict_data_id         bigint unsigned not null auto_increment,
   dict_type            varchar(100) not null comment '字典类型',
   data_name            varchar(100) comment '字典数据名称',
   data_value           varchar(100) comment '字典键值',
   data_sort            int(4) unsigned default 0 comment '字典排序',
   is_default           int(1) unsigned default 0 comment '是否默认值  0  否  1  是',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (dict_data_id)
);

alter table core_dict_data comment '字典数据';

/*==============================================================*/
/* Table: core_login_log                                        */
/*==============================================================*/
create table core_login_log
(
   log_id               bigint unsigned not null auto_increment,
   login_user_id        bigint unsigned not null comment '登录用户ID',
   login_user_name      varchar (20) not null comment '登录用户名',
   login_ip             varchar (20) comment '登录ip',
   login_time           datetime comment '登录时间',
   device               varchar (50) comment '登录使用设备',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (log_id)
);

alter table core_login_log comment '登录日志';

/*==============================================================*/
/* Table: core_operation_log                                    */
/*==============================================================*/
create table core_operation_log
(
   log_id               bigint unsigned not null auto_increment,
   user_id              bigint unsigned comment '操作用户ID',
   username             varchar (20) comment '操作用户名',
   operation_content    varchar (300) comment '操作内容',
   operation_time       datetime not null comment '操作时间',
   operation_ip         varchar (20) comment '操作ip',
   operation_uri        varchar (64) comment '操作请求地址',
   operation_method     varchar (10) comment '操作请求方式',
   operation_type       int(2) comment '操作类型',
   operation_params     varchar (255) comment '操作请求参数json',
   operation_device     varchar(50) comment '操作设备',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (log_id)
);

alter table core_operation_log comment '操作日志';

/*==============================================================*/
/* Table: core_param                                            */
/*==============================================================*/
create table core_param
(
   param_id             bigint unsigned not null auto_increment,
   param_name           varchar(50) not null comment '参数名称',
   param_key            varchar(50) comment '参数键',
   param_value          varchar(100) comment '参数值',
   param_desc           varchar(50) comment '参数描述',
   system_flag          tinyint(1) unsigned not null default 0 comment '是否为系统参数,系统参数不允许修改 1 是 0 否',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (param_id)
);

alter table core_param comment '系统参数';

/*==============================================================*/
/* Table: core_post                                             */
/*==============================================================*/
create table core_post
(
   post_id              bigint unsigned not null auto_increment comment '岗位ID',
   post_code            varchar(64) not null comment '岗位编码',
   post_name            varchar(100) not null comment '岗位名称',
   post_sort            int(4) unsigned comment '显示顺序',
   remark               varchar(500) comment '备注',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (post_id)
);

alter table core_post comment '岗位信息';

/*==============================================================*/
/* Index: core_post_uk_1                                        */
/*==============================================================*/
create unique index core_post_uk_1 on core_post
(
   post_code
);

/*==============================================================*/
/* Table: core_resource                                         */
/*==============================================================*/
create table core_resource
(
   resource_id          bigint unsigned not null auto_increment,
   resource_name        varchar(20) not null comment '资源名称',
   resource_type        varchar(2) not null comment '资源类型(G 菜单组 M 菜单  O 按钮)',
   resource_key         varchar(36) not null comment '资源标识符',
   resource_uri         varchar(50) comment '资源路径',
   resource_redirect    varchar(50) comment '资源重定向',
   resource_view        varchar(50) comment '资源视图',
   resource_icon        varchar(100) binary comment '资源图标',
   resource_perms       varchar(20) comment '资源权限标识',
   resource_level       int(1) unsigned default 0 comment '权限等级 0-99  0为顶级',
   parent_resource_id   bigint unsigned comment '父级资源ID',
   sort                 int(4) unsigned default 0 comment '排序',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (resource_id)
);

alter table core_resource comment '资源信息';

/*==============================================================*/
/* Table: core_role                                             */
/*==============================================================*/
create table core_role
(
   role_id              bigint unsigned not null auto_increment,
   role_name            varchar(20) not null comment '角色名称',
   role_key             varchar(20) not null comment '角色权限标识',
   role_desc            varchar(30) comment '角色描述',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (role_id)
);

alter table core_role comment '角色信息';

/*==============================================================*/
/* Table: core_role_resource_mapping                            */
/*==============================================================*/
create table core_role_resource_mapping
(
   id                   bigint unsigned not null auto_increment,
   resource_id          bigint unsigned not null,
   role_id              bigint unsigned not null,
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (id)
);

alter table core_role_resource_mapping comment '角色资源映射';

/*==============================================================*/
/* Index: core_role_resource_mapping_uk1                        */
/*==============================================================*/
create unique index core_role_resource_mapping_uk1 on core_role_resource_mapping
(
   resource_id,
   role_id
);

/*==============================================================*/
/* Table: core_system_notice                                    */
/*==============================================================*/
create table core_system_notice
(
   notice_id            bigint not null auto_increment,
   notice_title         varchar(100) not null comment '公告标题',
   sort                 int(5) not null default 1 comment '排序',
   notice_content       text comment '公告内容',
   publish_id           bigint comment '发布人ID',
   publish_name         varchar(20) comment '发布人名称',
   publish_time         datetime comment '发布时间',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (notice_id)
);

alter table core_system_notice comment '系统公告';

/*==============================================================*/
/* Table: core_task_log                                         */
/*==============================================================*/
create table core_task_log
(
   task_log_id          bigint unsigned not null auto_increment comment '任务日志ID',
   task_name            varchar(64) not null comment '任务名称',
   task_group           varchar(64) not null comment '任务组名',
   task_desc            varchar(100) comment '任务描述',
   job_message          varchar(500) comment '日志信息',
   task_status          int(1) unsigned default 0 comment '执行状态  0 正常  1  异常',
   exception_info       text comment '异常信息',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (task_log_id)
);

alter table core_task_log comment '定时任务日志';

/*==============================================================*/
/* Table: core_user                                             */
/*==============================================================*/
create table core_user
(
   user_id              bigint unsigned not null auto_increment,
   user_name            varchar(20) not null comment '用户名',
   password             varchar(32) not null comment '密码',
   mobile               varchar(20) comment '手机号',
   email                varchar(50) comment '邮箱',
   city                 varchar(10) comment '所在城市代码',
   join_time            datetime comment '注册时间',
   last_login           datetime comment '最后登录时间',
   user_status          varchar(1) not null default 'N' comment '用户状态 ''N'' 正常 ''L'' 锁定',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (user_id)
);

alter table core_user comment '用户信息';

/*==============================================================*/
/* Index: core_user_idx1                                        */
/*==============================================================*/
create index core_user_idx1 on core_user
(
   user_name
);

/*==============================================================*/
/* Index: core_user_idx2                                        */
/*==============================================================*/
create index core_user_idx2 on core_user
(
   mobile
);

/*==============================================================*/
/* Table: core_user_dept_mapping                                */
/*==============================================================*/
create table core_user_dept_mapping
(
   mapping_id           bigint unsigned not null auto_increment,
   user_id              bigint unsigned not null comment '用户ID',
   dept_id              bigint unsigned not null comment '部门id',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (mapping_id)
);

alter table core_user_dept_mapping comment '用户部门映射';

/*==============================================================*/
/* Table: core_user_group                                       */
/*==============================================================*/
create table core_user_group
(
   group_id             bigint unsigned not null auto_increment,
   group_name           varchar(20) not null comment '用户组名称',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (group_id)
);

alter table core_user_group comment '用户组';

/*==============================================================*/
/* Table: core_user_group_mapping                               */
/*==============================================================*/
create table core_user_group_mapping
(
   mapping_id           bigint unsigned not null auto_increment,
   group_id             bigint unsigned not null comment '用户组ID',
   user_id              bigint unsigned not null comment '用户ID',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (mapping_id)
);

alter table core_user_group_mapping comment '用户与用户组映射';

/*==============================================================*/
/* Table: core_user_group_role_mapping                          */
/*==============================================================*/
create table core_user_group_role_mapping
(
   mapping_id           bigint unsigned not null auto_increment,
   group_id             bigint unsigned not null comment '用户组ID',
   role_id              bigint unsigned not null comment '角色ID',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (mapping_id)
);

alter table core_user_group_role_mapping comment '用户组角色映射';

/*==============================================================*/
/* Table: core_user_post_mapping                                */
/*==============================================================*/
create table core_user_post_mapping
(
   mapping_id           bigint unsigned not null auto_increment,
   user_id              bigint unsigned not null comment '用户ID',
   post_id              bigint unsigned not null comment '岗位ID',
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (mapping_id)
);

alter table core_user_post_mapping comment '用户岗位映射';

/*==============================================================*/
/* Table: core_user_role_mapping                                */
/*==============================================================*/
create table core_user_role_mapping
(
   id                   bigint unsigned not null auto_increment,
   user_id              bigint unsigned not null,
   role_id              bigint unsigned not null,
   ct                   datetime comment '创建时间',
   ut                   datetime comment '更新时间',
   is_del               int(1) unsigned not null default 0 comment '删除标识位 0 未删除  1 已删除',
   version              bigint unsigned default 0 comment '乐观锁标识',
   primary key (id)
);

alter table core_user_role_mapping comment '用户角色映射';
