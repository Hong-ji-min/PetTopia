insert into tbl_hospital(ent_id, ent_name,ent_phone,ent_address,office_hours)
values (1,'마이펫동물의료센터','02-512-2575','서울 강남구 삼성로 573','10:00 - 22:00'), -- 16906667
       (2,'청담우리동물병원','02-541-7515','서울 강남구 삼성로 614','24시간 영업'), -- 19883932
       (3,'닥터펫동물의료센터','02-3443-8275','서울 강남구 선릉로 620','10:00 - 18:00'), -- 14569826
       (4,'혜민동물병원','02-454-8275','서울 강남구 봉은사로57길 59','14:00 - 17:00'), -- 12503605
       (5,'퍼피즌동물병원','02-541-2651','서울 강남구 선릉로 636','09:30 - 20:00'), -- 14624117
       (6,'아크리스동물의료센터','02-583-7582','서울 강남구 봉은사로104길 10','10:00 - 19:00'), -- 14833110
       (7,'중앙동물메디컬센터','02-512-3331','서울 강남구 영동대로 630','10:00 - 22:00'), -- 14492440
       (8, '강남예치과동물병원', '02-517-5585', '서울 강남구 선릉로126길 6', '09:30 - 18:30'), -- 316369703
       (9, '삼성펫클리닉', '02-3453-0077', '서울 강남구 봉은사로 640', '10:00 - 17:00'), -- 1084667424
       (10, 'VIP동물의료센터 청담점', '02-511-7522', '서울 강남구 삼성로133길 7', '24시간 영업'), -- 356547106
       (11, '일마레동물메디컬센터', '02-3445-7275', '서울 강남구 영동대로 708', '10:00 - 14:00'), -- 2023021097
       (12, '청담아이윌24시동물병원', '02-6925-7021', '서울 강남구 삼성로133길 3', '24시간 영업'), -- 02-6925-7021
       (13, '원동물병원', '02-555-6835', '서울 강남구 역삼로 459', '10:00 - 18:00'), -- 02-555-6835
       (14, 'VIP동물한방재활의학센터byDr신사경', '02-6952-7524', '서울 강남구 삼성로133길 7', '10:00 - 19:00'); -- 1072121256

insert into tbl_pharmacy(ent_id, ent_name, ent_phone, ent_address, office_hours)
values
    (15, '강남동물약국', '02-501-4397', '서울 강남구 논현로64길 22', '10:00 - 18:00'), -- 12817398
    (16, '삼성온누리약국', '02-566-0954', '서울 강남구 테헤란로 534', '09:00 - 19:00'), -- 59326591
    (17, '청담엘약국', '02-512-0999', '서울 강남구 학동로101길 11', '09:30 - 18:30'), -- 1924188326
    (18, '청담소망약국', '02-6094-1231', '서울 강남구 학동로 417', '09:00 - 20:00'), -- 838613787
    (19, '강남셀리뉴약국', '02-400-1640', '서울 강남구 도산대로 513', '09:00 - 20:00'), -- 912815912
    (20, '루이약국', '02-567-7750', '서울 강남구 봉은사로44길 31', '24시간 영업'), -- 457412737
    (21, '샘약국', '02-558-3347', '서울 강남구 테헤란로 322', '09:00 - 18:30'), -- 8361362
    (22, '강남태평양약국', '02-555-2017', '서울 강남구 선릉로 309', '08:30 - 19:30'), -- 1470567107
    (23, '더봄약국', '02-555-2336', '서울 강남구 선릉로 325', '09:00 - 18:00'), -- 1144561496
    (24, '청담엔약국', '02-543-3303', '서울 강남구 도산대로 330', '10:00 - 20:10'), -- 1888346774
    (25, '한티역약국', '02-3453-9982', '서울 강남구 도곡로 323', '08:30 - 19:30'), -- 609203195
    (26, '논현약국', '02-544-3922', '서울 강남구 선릉로129길 22', '09:00 - 22:00'), -- 13513389
    (27, '잠실팜약국', '070-8080-4509', '서울 송파구 석촌호수로 80', '09:00 - 20:00'), -- 2065258870
    (28, '샤인약국', '02-6958-5937', '서울 강남구 압구정로50길 11', '10:00 - 20:30'); -- 1537737042


insert into tbl_salon(ent_id, ent_name, ent_phone, ent_address, office_hours)
values
    (29, '릴리줄리살롱', '02-549-1128', '서울 강남구 삼성로115길 42', '10:00 - 19:00'), -- 955776953
    (30, '개스타일', '02-408-1001', '서울 강남구 봉은사로55길 24', '이용시간을 알려주세요'), -- 1965039727
    (31, '강아지집', '010-4257-0802', '서울 강남구 봉은사로71길 32', '10:00 - 17:00'), -- 469379492
    (32, '에이컷', '02-501-1288', '서울 강남구 테헤란로77길 52', '10:00 - 18:00'), -- 27310828
    (33, '애니살롱 1호점', '010-3579-1550', '서울 강남구 봉은사로109길 22-5', '10:00 - 19:00'), -- 1956983295
    (34, '중앙애견미용실', '010-8183-2094', '서울 강남구 영동대로 630', '10:00 - 20:00'), -- 652935909
    (35, '부띠끄몽뚜뚜', '070-4196-3008', '서울 강남구 선릉로122길 4', '10:00 - 19:00'), -- 1939648528
    (36, '플러피애견미용실', '02-514-0010', '서울 강남구 압구정로79길 61', '09:00 - 17:00'), -- 2012763893
    (37, '다올', '02-3453-0001', '서울 강남구 도산대로99길 19', '10:00 - 19:00'), -- 173392795
    (38, '펌킨펫하우스 청담', '02-6204-5960', '서울 강남구 봉은사로43길 21', '08:00 - 20:00'), -- 72073323
    (39, '슈몽', '02-6415-0202', '서울 강남구 테헤란로53길 57-17', '09:30 - 17:30'), -- 11418449
    (40, 'MM애견공방', '02-418-5559', '서울 송파구 백제고분로 165', '08:00 - 20:00'); -- 1618762036
