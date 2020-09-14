INSERT INTO `dsb`.`role` (`roleid`, `role_name`) VALUES('1', 'Retail')
INSERT INTO `dsb`.`role` (`roleid`, `role_name`) VALUES('2', 'Commercial')

INSERT INTO `dsb`.`employee` (`employeeid`, `employee_user_name`, `initials`, `password`, `surname`, `role_roleid`) VALUES ('44', 'linda.', 'L.', 'linda', 'Haest', '1' );
INSERT INTO `dsb`.`employee` (`employeeid`, `employee_user_name`, `initials`, `password`, `surname`, `role_roleid`) VALUES ('45', 'thijs.', 'T.', 'thijs', 'Rodenburg', '2');

INSERT INTO dsb.sector VALUES (0, 'Bouw')
INSERT INTO dsb.sector VALUES (1, 'Cultuur, sport en recreatie')
INSERT INTO dsb.sector VALUES (2, 'Detailhandel')
INSERT INTO dsb.sector VALUES (3, 'Energie, water en milieu')
INSERT INTO dsb.sector VALUES (4, 'Financiële instellingen')
INSERT INTO dsb.sector VALUES (5, 'Gezondheid')
INSERT INTO dsb.sector VALUES (6, 'Groothandel')
INSERT INTO dsb.sector VALUES (7, 'Horeca')
INSERT INTO dsb.sector VALUES (8, 'ICT en media')
INSERT INTO dsb.sector VALUES (9, 'Industrie')
INSERT INTO dsb.sector VALUES (10, 'Land- en tuinbouw')
INSERT INTO dsb.sector VALUES (11, 'Logistiek')
INSERT INTO dsb.sector VALUES (12, 'Overig')
INSERT INTO dsb.sector VALUES (13, 'Zakelijke diensten')

INSERT INTO `dsb`.`address` (`addressid`, `city`, `house_number`, `street`) VALUES ('11', 'Amsterdam', '1', 'Straat');
INSERT INTO `dsb`.`customer` (`customerid`, `initials`, `password`, `social_security_no`, `surname`, `username`, `address_addressid`) VALUES ('11', 'D.', 'dennis', '123456', 'Kramer', 'dennis', '11');
INSERT INTO `dsb`.`customer` (`customerid`, `initials`, `password`, `social_security_no`, `surname`, `username`, `address_addressid`) VALUES ('12', 'E.M.', 'miel', '123456', 'van Welzen', 'miel', '11');

INSERT INTO `dsb`.`company` (`company_id`, `btwno`, `kvkno`, `name`, `sector_sector_id`, `account_manager`) VALUES ('11', 'NL0012345B03', '14729462', 'HvA Corp.', 12, '45');
INSERT INTO `dsb`.`company` (`company_id`, `btwno`, `kvkno`, `name`, `sector_sector_id`, `account_manager`) VALUES ('12', 'NL0012345B04', '66666666', 'Evil Corp.', 4, '45');
INSERT INTO `dsb`.`company` (`company_id`, `btwno`, `kvkno`, `name`, `sector_sector_id`, `account_manager`) VALUES ('13', 'NL0012345B05', '26492741', 'AvH Corp.', 12, '45');

INSERT INTO `dsb`.`account` (`accountid`, `account_no`, `balance`) VALUES ('110', 'NL40DSBB0123456789', '1000');
INSERT INTO `dsb`.`account` (`accountid`, `account_no`, `balance`) VALUES ('111', 'NL41DSBB0123456789', '1500');
INSERT INTO `dsb`.`account` (`accountid`, `account_no`, `balance`) VALUES ('112', 'NL42DSBB0123456789', '1250');
INSERT INTO `dsb`.`account` (`accountid`, `account_no`, `balance`) VALUES ('113', 'NL43DSBB0123456789', '10000');
INSERT INTO `dsb`.`account` (`accountid`, `account_no`, `balance`) VALUES ('114', 'NL44DSBB0123456789', '12500');
INSERT INTO `dsb`.`account` (`accountid`, `account_no`, `balance`) VALUES ('115', 'NL45DSBB0123456789', '15000');

INSERT INTO `dsb`.`consumer_account` (`accountid`) VALUES ('110');
INSERT INTO `dsb`.`consumer_account` (`accountid`) VALUES ('111');
INSERT INTO `dsb`.`consumer_account` (`accountid`) VALUES ('112');

INSERT INTO `dsb`.`smeaccount` (`accountid`, `company_company_id`) VALUES ('113', '11');
INSERT INTO `dsb`.`smeaccount` (`accountid`, `company_company_id`) VALUES ('114', '11');
INSERT INTO `dsb`.`smeaccount` (`accountid`, `company_company_id`) VALUES ('115', '11');

INSERT INTO dsb.account_holders VALUES (110, 11);
INSERT INTO dsb.account_holders VALUES (111, 11);
INSERT INTO dsb.account_holders VALUES (112, 11);
INSERT INTO dsb.account_holders VALUES (113, 11);
INSERT INTO dsb.account_holders VALUES (114, 11);
INSERT INTO dsb.account_holders VALUES (115, 11);

INSERT INTO `dsb`.`company_accounts` (`company_company_id`, `accounts_accountid`) VALUES ('11', '113');
INSERT INTO `dsb`.`company_accounts` (`company_company_id`, `accounts_accountid`) VALUES ('11', '114');
INSERT INTO `dsb`.`company_accounts` (`company_company_id`, `accounts_accountid`) VALUES ('11', '115');


INSERT INTO `dsb`.`transaction` (`transactionid`, `message`, `transaction_amount`, `transaction_timestamp`, credit_account_accountid, debit_account_accountid) VALUES ('300', 'Huur', 100, '2020-01-01 01:01:01', 110, 111);
INSERT INTO `dsb`.`transaction` (`transactionid`, `message`, `transaction_amount`, `transaction_timestamp`, credit_account_accountid, debit_account_accountid) VALUES ('301', 'Etentje', 100, '2020-01-02 01:01:01', 110, 112);
INSERT INTO `dsb`.`transaction` (`transactionid`, `message`, `transaction_amount`, `transaction_timestamp`, credit_account_accountid, debit_account_accountid) VALUES ('302', 'Hondevoer', 100, '2020-01-03 01:01:01', 111, 113);
INSERT INTO `dsb`.`transaction` (`transactionid`, `message`, `transaction_amount`, `transaction_timestamp`, credit_account_accountid, debit_account_accountid) VALUES ('303', 'Ballonvaart', 100, '2020-01-04 01:01:01', 110, 114);
INSERT INTO `dsb`.`transaction` (`transactionid`, `message`, `transaction_amount`, `transaction_timestamp`, credit_account_accountid, debit_account_accountid) VALUES ('304', 'Verjaardag', 100, '2020-01-05 01:01:01', 111, 115);




