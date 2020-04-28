-- 用户表
insert into nf_user(user_phone, user_email, user_name, user_img_url, user_pwd, status, admin_id, grade_id, vip_id, user_logon_time, user_coin, user_exp) values
('18998280000','123456789@qq.com','今晚打老虎','img/xxx/aaa','baigei',0,null,null,null,'1999/1/1',999,999),
('18998281111','222222222@qq.com','今晚一起去吃烤肉吧','img/xxx/bbb','kaorou',0,null,null,null,'2000-02-02',888,888)

-- 管理员
insert into nf_admin(admin_type, admin_group_id, user_id, admin_logon_time) values
(1,1,1,'1999/1/1');

-- 消息通知表
insert into nf_message(user_id, message_status, message_read, author_id, message_content, message_time) values
(2,1,0,1,'今晚打老虎给你发了信息','2018-08-08');