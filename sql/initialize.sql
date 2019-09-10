INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('首页', 'G', 'index', '/', '/index/dashboard', 'BasicLayout', NULL, NULL, 0, NULL);
-- 系统首页
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统首页', 'G', 'admin_index', '/index', '/index/dashboard', 'RouteView', 'cloud', NULL, 1, '1');
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('仪表盘', 'M', 'dashboard', '/dashboard', '', 'dashboard/Analysis', 'cloud', NULL, 2, '2');
-- 系统管理相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统管理', 'G', 'sys_manager', '/system', '/core/user', 'RouteView', 'deployment-unit', NULL, 1, '1');
-- 系统管理子菜单相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('基础模块', 'G', 'core_module', '/core', '/core/user', 'PageView', 'global', NULL, 2, '4');
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统配置', 'G', 'sys_config', '/config', '/config/param', 'PageView', 'setting', NULL, 2, '4');
-- 工具箱相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统工具', 'G', 'sys_tool', '/tool', '/tool/task', 'RouteView', 'tool', NULL, 1, '1');
-- 日志管理
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('日志管理', 'G', 'log_manager', '/log', '/log/operationlog', 'PageView', 'book', NULL, 1, '1');
-- 常用功能
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('常用功能', 'G', 'sys_common', '/common', '/common/article', 'PageView', 'inbox', NULL, 1, '1');

-- 用户相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户管理', 'M', 'user', '/user', NULL, 'user/UserView', NULL, 'user:view', 3, 5);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户信息新增', 'O', 'add', NULL, NULL, NULL, NULL, 'user:add', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户信息删除', 'O', 'del', NULL, NULL, NULL, NULL, 'user:del', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户信息修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'user:edit', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户信息查询', 'O', 'get', NULL, NULL, NULL, NULL, 'user:get', 4, @parentId);
-- 用户组管理
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户组', 'M', 'usergroup', '/usergroup', NULL, 'usergroup/UserGroupView', NULL, 'usergroup:view', 3, 5);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户组新增', 'O', 'add', NULL, NULL, NULL, NULL, 'usergroup:add', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户组删除', 'O', 'del', NULL, NULL, NULL, NULL, 'usergroup:del', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户组修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'usergroup:edit', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('用户组查询', 'O', 'get', NULL, NULL, NULL, NULL, 'usergroup:get', 4, @parentId);
-- 角色相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('角色管理', 'M', 'role', '/role', NULL, 'role/RoleView', NULL, 'role:view', 3, 5);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('角色信息新增', 'O', 'add', NULL, NULL, NULL, NULL, 'role:add', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('角色信息删除', 'O', 'del', NULL, NULL, NULL, NULL, 'role:del', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('角色信息修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'role:edit', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('角色信息查询', 'O', 'get', NULL, NULL, NULL, NULL, 'role:get', 4, @parentId);
-- 权限相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('权限管理', 'M', 'resource', '/resource', NULL, 'resource/ResourceView', NULL, 'resource:view', 3, 5);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('权限信息新增', 'O', 'add', NULL, NULL, NULL, NULL, 'resource:add', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('权限信息删除', 'O', 'del', NULL, NULL, NULL, NULL, 'resource:del', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('权限信息修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'resource:edit', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('权限信息查询', 'O', 'get', NULL, NULL, NULL, NULL, 'resource:get', 4, @parentId);
-- 部门相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('部门管理', 'M', 'dept', '/dept', NULL, 'dept/DeptView', NULL, 'dept:view', 3, 5);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('部门信息新增', 'O', 'add', NULL, NULL, NULL, NULL, 'dept:add', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('部门信息删除', 'O', 'del', NULL, NULL, NULL, NULL, 'dept:del', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('部门信息修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'dept:edit', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('部门信息查询', 'O', 'get', NULL, NULL, NULL, NULL, 'dept:get', 4, @parentId);
-- 岗位相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('岗位管理', 'M', 'post', '/post', NULL, 'post/PostView', NULL, 'post:view', 3, 5);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('岗位信息新增', 'O', 'add', NULL, NULL, NULL, NULL, 'post:add', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('岗位信息删除', 'O', 'del', NULL, NULL, NULL, NULL, 'post:del', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('岗位信息修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'post:edit', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('岗位信息查询', 'O', 'get', NULL, NULL, NULL, NULL, 'post:get', 4, @parentId);

-- 系统参数相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统参数', 'M', 'param', '/param', NULL, 'param/ParamView', NULL, 'param:view', 3, 6);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统参数新增', 'O', 'add', NULL, NULL, NULL, NULL, 'param:add', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统参数删除', 'O', 'del', NULL, NULL, NULL, NULL, 'param:del', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统参数修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'param:edit', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统参数查询', 'O', 'get', NULL, NULL, NULL, NULL, 'param:get', 4, @parentId);
-- 数据字典相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('数据字典', 'M', 'dictdata', '/dictdata', NULL, 'dictcatalog/DictCatalogView', NULL, 'dictdata:view', 3, 6);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('字典数据新增', 'O', 'add', NULL, NULL, NULL, NULL, 'dictdata:add', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('字典数据删除', 'O', 'del', NULL, NULL, NULL, NULL, 'dictdata:del', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('字典数据修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'dictdata:edit', 4, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('字典数据查询', 'O', 'get', NULL, NULL, NULL, NULL, 'dictdata:get', 4, @parentId);

-- 工具箱相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('定时任务', 'M', 'task', '/task', NULL, 'task/TaskView', NULL, NULL, 2, 7);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('代码生成器', 'M', 'gen_code', '/gen', NULL, 'tool/GenCodeView', NULL, NULL, 2, 7);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('数据库监控', 'M', 'database_monitor', '/database_monitor', 'http://localhost:21550/tool/datasource/index', 'IframeView', NULL, NULL, 2, 7);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('服务器监控', 'M', 'server_monitor', '/server_monitor', 'http://localhost:21550/tool/datasource/index', 'IframeView', NULL, NULL, 2, 7);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('接口文档', 'M', 'api_doc', '/api', 'http://localhost:21550/swagger-ui.html', 'IframeView', NULL, NULL, 2, 7);

-- 操作日志相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('操作日志', 'M', 'operationlog', '/operationlog', NULL, 'operationlog/OperationLogView', NULL, 'operationlog:view', 2, 8);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('操作日志新增', 'O', 'add', NULL, NULL, NULL, NULL, 'operationlog:add', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('操作日志删除', 'O', 'del', NULL, NULL, NULL, NULL, 'operationlog:del', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('操作日志修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'operationlog:edit', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('操作日志查询', 'O', 'get', NULL, NULL, NULL, NULL, 'operationlog:get', 3, @parentId);
-- 登录日志相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('登录日志', 'M', 'loginlog', '/loginlog', NULL, 'loginlog/LoginLogView', NULL, 'loginlog:view', 2, 8);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('登录日志新增', 'O', 'add', NULL, NULL, NULL, NULL, 'loginlog:add', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('登录日志删除', 'O', 'del', NULL, NULL, NULL, NULL, 'loginlog:del', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('登录日志修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'loginlog:edit', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('登录日志查询', 'O', 'get', NULL, NULL, NULL, NULL, 'loginlog:get', 3, @parentId);
-- 定时任务日志相关
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('定时任务日志', 'M', 'tasklog', '/tasklog', NULL, 'tasklog/TaskLogView', NULL, 'tasklog:view', 2, 8);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('定时任务日志新增', 'O', 'add', NULL, NULL, NULL, NULL, 'tasklog:add', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('定时任务日志删除', 'O', 'del', NULL, NULL, NULL, NULL, 'tasklog:del', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('定时任务日志修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'tasklog:edit', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('定时任务日志查询', 'O', 'get', NULL, NULL, NULL, NULL, 'tasklog:get', 3, @parentId);

-- 文章管理
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章信息', 'M', 'article', '/article', NULL, 'article/ArticleView', NULL, 'article:view', 2, 9);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章信息新增', 'O', 'add', NULL, NULL, NULL, NULL, 'article:add', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章信息删除', 'O', 'del', NULL, NULL, NULL, NULL, 'article:del', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章信息修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'article:edit', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章信息查询', 'O', 'get', NULL, NULL, NULL, NULL, 'article:get', 3, @parentId);
-- 文章分类管理
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章分类', 'M', 'articlecategory', '/articlecategory', NULL, 'articlecategory/ArticleCategoryView', NULL, 'articlecategory:view', 2, 9);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章分类新增', 'O', 'add', NULL, NULL, NULL, NULL, 'articlecategory:add', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章分类删除', 'O', 'del', NULL, NULL, NULL, NULL, 'articlecategory:del', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章分类修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'articlecategory:edit', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('文章分类查询', 'O', 'get', NULL, NULL, NULL, NULL, 'articlecategory:get', 3, @parentId);
-- 广告管理
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('广告轮播', 'M', 'ads', '/ads', NULL, 'ads/AdsView', NULL, 'ads:view', 2, 9);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('广告轮播新增', 'O', 'add', NULL, NULL, NULL, NULL, 'ads:add', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('广告轮播删除', 'O', 'del', NULL, NULL, NULL, NULL, 'ads:del', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('广告轮播修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'ads:edit', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('广告轮播查询', 'O', 'get', NULL, NULL, NULL, NULL, 'ads:get', 3, @parentId);
-- 系统公告
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统公告', 'M', 'systemnotice', '/systemnotice', NULL, 'systemnotice/SystemNoticeView', NULL, 'systemnotice:view', 2, 9);
SELECT @parentId := LAST_INSERT_ID();
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统公告新增', 'O', 'add', NULL, NULL, NULL, NULL, 'systemnotice:add', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统公告删除', 'O', 'del', NULL, NULL, NULL, NULL, 'systemnotice:del', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统公告修改', 'O', 'edit', NULL, NULL, NULL, NULL, 'systemnotice:edit', 3, @parentId);
INSERT INTO `core_resource` (`resource_name`, `resource_type`, `resource_key`, `resource_uri`, `resource_redirect`, `resource_view`, `resource_icon`, `resource_perms`, `resource_level`, `parent_resource_id`)
VALUES ('系统公告查询', 'O', 'get', NULL, NULL, NULL, NULL, 'systemnotice:get', 3, @parentId);


-- 角色信息
INSERT INTO `core_role` (`role_id`, `role_name`, `role_key`, `role_desc`, `ct`, `ut`, `is_del`, `version`)
VALUES ('1', '管理员', 'admin', '超级管理员', NULL, NULL, '0', '0');

-- 用户信息
INSERT INTO `core_user` (`user_id`, `user_name`, `password`, `mobile`, `email`, `city`, `join_time`, `last_login`, `user_status`, `ct`, `ut`, `is_del`, `version`)
VALUES ('1', 'admin', '8266108a4e337e9c404ede72b218bca4', '15912345678', '123@qq.com', '0755', NULL, NULL, 'N', NULL, NULL, '0', '0');
