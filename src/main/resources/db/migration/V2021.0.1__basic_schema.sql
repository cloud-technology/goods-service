CREATE
    TABLE
        goods(
            goods_id VARCHAR(60) NOT NULL COMMENT '商品編號',
            goods_name VARCHAR(60) NOT NULL COMMENT '商品名稱',
            unit_price INT NOT NULL COMMENT '單價',
            inventory INT NOT NULL COMMENT '庫存數量',
            version INT NOT NULL COMMENT '版本鎖',
            created_by VARCHAR(60) NOT NULL,
            created_date datetime NOT NULL,
            last_modified_by VARCHAR(60) NOT NULL,
            last_modified_date datetime NOT NULL,
            PRIMARY KEY(goods_id)
        ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '商品資料';
