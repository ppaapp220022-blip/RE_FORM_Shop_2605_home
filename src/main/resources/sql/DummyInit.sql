-- 1. MEMBER (50명)
INSERT INTO member (email, nickname, role, status, warning_count, email_event, manner_score, created_at)
VALUES
    ('user01@reform.com', '유니폼헌터01', 'USER', 'ACTIVE', 0, true, 4.50, NOW()),
    ('user02@reform.com', '스포츠마켓02', 'USER', 'ACTIVE', 0, false, 4.20, NOW()),
    ('user03@reform.com', '유니폼셀러03', 'USER', 'ACTIVE', 0, true, 3.80, NOW()),
    ('user04@reform.com', '레어유니폼04', 'USER', 'ACTIVE', 0, true, 4.70, NOW()),
    ('user05@reform.com', '스포츠팬05', 'USER', 'ACTIVE', 0, false, 4.10, NOW()),
    ('user06@reform.com', '유니폼컬렉터06', 'USER', 'ACTIVE', 0, true, 4.90, NOW()),
    ('user07@reform.com', '중고마켓07', 'USER', 'ACTIVE', 0, false, 3.50, NOW()),
    ('user08@reform.com', '스포츠굿즈08', 'USER', 'ACTIVE', 0, true, 4.30, NOW()),
    ('user09@reform.com', '유니폼거래09', 'USER', 'ACTIVE', 0, true, 4.60, NOW()),
    ('user10@reform.com', '레플리카킹10', 'USER', 'ACTIVE', 0, false, 4.00, NOW()),
    ('user11@reform.com', '축구팬11', 'USER', 'ACTIVE', 0, true, 4.20, NOW()),
    ('user12@reform.com', '야구매니아12', 'USER', 'ACTIVE', 0, false, 3.90, NOW()),
    ('user13@reform.com', '농구러버13', 'USER', 'ACTIVE', 0, true, 4.50, NOW()),
    ('user14@reform.com', '배구팬14', 'USER', 'ACTIVE', 0, true, 4.10, NOW()),
    ('user15@reform.com', '이스포츠팬15', 'USER', 'ACTIVE', 0, false, 4.80, NOW()),
    ('user16@reform.com', '유니폼중고16', 'USER', 'ACTIVE', 0, true, 3.70, NOW()),
    ('user17@reform.com', '스포츠웨어17', 'USER', 'ACTIVE', 0, false, 4.40, NOW()),
    ('user18@reform.com', '레트로유니폼18', 'USER', 'ACTIVE', 0, true, 4.20, NOW()),
    ('user19@reform.com', '유니폼샵19', 'USER', 'ACTIVE', 0, true, 4.60, NOW()),
    ('user20@reform.com', '스포츠중고20', 'USER', 'ACTIVE', 0, false, 3.80, NOW()),
    ('user21@reform.com', '유니폼마켓21', 'USER', 'ACTIVE', 0, true, 4.30, NOW()),
    ('user22@reform.com', '굿즈헌터22', 'USER', 'ACTIVE', 0, false, 4.50, NOW()),
    ('user23@reform.com', '스포츠팬23', 'USER', 'ACTIVE', 0, true, 4.10, NOW()),
    ('user24@reform.com', '유니폼셀24', 'USER', 'ACTIVE', 0, true, 4.70, NOW()),
    ('user25@reform.com', '중고유니폼25', 'USER', 'ACTIVE', 0, false, 3.90, NOW()),
    ('user26@reform.com', '스포츠굿즈26', 'USER', 'ACTIVE', 0, true, 4.20, NOW()),
    ('user27@reform.com', '유니폼킹27', 'USER', 'ACTIVE', 0, false, 4.50, NOW()),
    ('user28@reform.com', '레어굿즈28', 'USER', 'ACTIVE', 0, true, 4.80, NOW()),
    ('user29@reform.com', '스포츠마켓29', 'USER', 'ACTIVE', 0, true, 4.00, NOW()),
    ('user30@reform.com', '유니폼컬렉30', 'USER', 'ACTIVE', 0, false, 4.30, NOW()),
    ('user31@reform.com', '야구유니폼31', 'USER', 'ACTIVE', 0, true, 4.10, NOW()),
    ('user32@reform.com', '축구중고32', 'USER', 'ACTIVE', 0, false, 4.60, NOW()),
    ('user33@reform.com', '농구굿즈33', 'USER', 'ACTIVE', 0, true, 3.80, NOW()),
    ('user34@reform.com', '스포츠웨어34', 'USER', 'ACTIVE', 0, true, 4.40, NOW()),
    ('user35@reform.com', '유니폼거래35', 'USER', 'ACTIVE', 0, false, 4.20, NOW()),
    ('user36@reform.com', '레플리카36', 'USER', 'ACTIVE', 0, true, 4.50, NOW()),
    ('user37@reform.com', '스포츠팬37', 'USER', 'ACTIVE', 0, false, 3.70, NOW()),
    ('user38@reform.com', '유니폼샵38', 'USER', 'ACTIVE', 0, true, 4.90, NOW()),
    ('user39@reform.com', '중고마켓39', 'USER', 'ACTIVE', 0, true, 4.10, NOW()),
    ('user40@reform.com', '굿즈마켓40', 'USER', 'ACTIVE', 0, false, 4.30, NOW()),
    ('user41@reform.com', '유니폼헌터41', 'USER', 'ACTIVE', 0, true, 4.60, NOW()),
    ('user42@reform.com', '스포츠중고42', 'USER', 'ACTIVE', 0, false, 4.20, NOW()),
    ('user43@reform.com', '레어유니폼43', 'USER', 'ACTIVE', 0, true, 4.50, NOW()),
    ('user44@reform.com', '유니폼마켓44', 'USER', 'ACTIVE', 0, true, 3.90, NOW()),
    ('user45@reform.com', '스포츠굿즈45', 'USER', 'ACTIVE', 0, false, 4.70, NOW()),
    ('user46@reform.com', '유니폼셀러46', 'USER', 'ACTIVE', 0, true, 4.10, NOW()),
    ('user47@reform.com', '중고유니폼47', 'USER', 'ACTIVE', 0, false, 4.40, NOW()),
    ('user48@reform.com', '스포츠팬48', 'USER', 'ACTIVE', 0, true, 4.20, NOW()),
    ('user49@reform.com', '유니폼컬렉49', 'USER', 'ACTIVE', 0, true, 4.80, NOW()),
    ('user50@reform.com', '굿즈헌터50', 'USER', 'ACTIVE', 0, false, 4.30, NOW());

-- 2. POINT_WALLET
SELECT member_id FROM member ORDER BY member_id DESC LIMIT 50; -- 확인용

INSERT INTO point_wallet (member_id, balance, withdrawable, pending)
SELECT member_id, 0, 0, 0 FROM member WHERE email LIKE 'user%@reform.com';

-- 3. POST
-- 1) BASEBALL (100개)
INSERT INTO post (seller_id, title, content, sport, team, uniform_name, grade, size, marking, price, delivery_type, status, view_count, wish_count, created_at, updated_at)
SELECT
    m.member_id,
    CONCAT(team_name, ' ', uniform_name, ' 유니폼 팝니다'),
    CONCAT('상태 ', grade, '급 유니폼입니다. 착용감 좋고 보관 잘 했습니다. 택배 거래 가능합니다.'),
    'BASEBALL',
    team_name,
    uniform_name,
    grade,
    size,
    marking,
    price,
    delivery_type,
    'ON_SALE',
    FLOOR(RAND() * 300),
    FLOOR(RAND() * 50),
    DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 60) DAY),
    DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 60) DAY)
FROM (
    SELECT * FROM (
    SELECT m.member_id FROM member m WHERE email LIKE 'user%@reform.com' ORDER BY RAND()
    ) AS shuffled
    LIMIT 100
    ) AS m
    JOIN (
    SELECT 1 AS idx, 'KIA 타이거즈' AS team_name, '2024 홈' AS uniform_name, 'S' AS grade, '100' AS size, false AS marking, 75000 AS price, 'DELIVERY' AS delivery_type UNION ALL
    SELECT 2, 'KIA 타이거즈', '2024 어웨이', 'A', '105', true, 65000, 'DELIVERY' UNION ALL
    SELECT 3, 'KIA 타이거즈', '2023 홈', 'B', '95', false, 45000, 'BOTH' UNION ALL
    SELECT 4, 'KIA 타이거즈', '2022 홈', 'A', '100', false, 55000, 'DELIVERY' UNION ALL
    SELECT 5, 'KIA 타이거즈', '이범호 레전드', 'S', '105', true, 120000, 'DELIVERY' UNION ALL
    SELECT 6, '삼성 라이온즈', '2024 홈', 'S', '100', false, 80000, 'DELIVERY' UNION ALL
    SELECT 7, '삼성 라이온즈', '2024 어웨이', 'A', '95', false, 60000, 'BOTH' UNION ALL
    SELECT 8, '삼성 라이온즈', '2023 홈', 'B', '105', true, 42000, 'DELIVERY' UNION ALL
    SELECT 9, '삼성 라이온즈', '레트로 유니폼', 'A', '100', false, 70000, 'DELIVERY' UNION ALL
    SELECT 10, '삼성 라이온즈', '오승환 마킹', 'S', '100', true, 150000, 'DELIVERY' UNION ALL
    SELECT 11, 'LG 트윈스', '2024 홈', 'S', '105', false, 85000, 'DELIVERY' UNION ALL
    SELECT 12, 'LG 트윈스', '2024 어웨이', 'A', '100', false, 65000, 'BOTH' UNION ALL
    SELECT 13, 'LG 트윈스', '2023 한국시리즈', 'S', '95', true, 180000, 'DELIVERY' UNION ALL
    SELECT 14, 'LG 트윈스', '오지환 마킹', 'A', '100', true, 90000, 'DELIVERY' UNION ALL
    SELECT 15, 'LG 트윈스', '레트로 홈', 'B', '105', false, 38000, 'DELIVERY' UNION ALL
    SELECT 16, '두산 베어스', '2024 홈', 'A', '100', false, 72000, 'DELIVERY' UNION ALL
    SELECT 17, '두산 베어스', '2024 어웨이', 'S', '95', false, 82000, 'BOTH' UNION ALL
    SELECT 18, '두산 베어스', '2023 홈', 'B', '105', true, 40000, 'DELIVERY' UNION ALL
    SELECT 19, '두산 베어스', '김재환 마킹', 'A', '100', true, 95000, 'DELIVERY' UNION ALL
    SELECT 20, '두산 베어스', '레트로 유니폼', 'A', '100', false, 68000, 'DELIVERY' UNION ALL
    SELECT 21, 'SSG 랜더스', '2024 홈', 'S', '105', false, 88000, 'DELIVERY' UNION ALL
    SELECT 22, 'SSG 랜더스', '2024 어웨이', 'A', '100', false, 68000, 'BOTH' UNION ALL
    SELECT 23, 'SSG 랜더스', '추신수 마킹', 'S', '100', true, 200000, 'DELIVERY' UNION ALL
    SELECT 24, 'SSG 랜더스', '2022 통합우승', 'S', '95', false, 150000, 'DELIVERY' UNION ALL
    SELECT 25, 'SSG 랜더스', '2023 홈', 'B', '105', false, 45000, 'DELIVERY' UNION ALL
    SELECT 26, '롯데 자이언츠', '2024 홈', 'A', '100', false, 70000, 'DELIVERY' UNION ALL
    SELECT 27, '롯데 자이언츠', '2024 어웨이', 'S', '105', false, 80000, 'BOTH' UNION ALL
    SELECT 28, '롯데 자이언츠', '이대호 레전드', 'S', '100', true, 180000, 'DELIVERY' UNION ALL
    SELECT 29, '롯데 자이언츠', '레트로 홈', 'B', '95', false, 35000, 'DELIVERY' UNION ALL
    SELECT 30, '롯데 자이언츠', '2023 홈', 'A', '100', false, 60000, 'DELIVERY' UNION ALL
    SELECT 31, 'NC 다이노스', '2024 홈', 'S', '105', false, 82000, 'DELIVERY' UNION ALL
    SELECT 32, 'NC 다이노스', '2020 한국시리즈', 'S', '100', true, 160000, 'DELIVERY' UNION ALL
    SELECT 33, 'NC 다이노스', '양의지 마킹', 'A', '95', true, 95000, 'BOTH' UNION ALL
    SELECT 34, 'NC 다이노스', '2023 어웨이', 'B', '105', false, 42000, 'DELIVERY' UNION ALL
    SELECT 35, 'NC 다이노스', '레트로 유니폼', 'A', '100', false, 65000, 'DELIVERY' UNION ALL
    SELECT 36, 'KT 위즈', '2024 홈', 'S', '100', false, 78000, 'DELIVERY' UNION ALL
    SELECT 37, 'KT 위즈', '2021 한국시리즈', 'S', '105', true, 155000, 'DELIVERY' UNION ALL
    SELECT 38, 'KT 위즈', '강백호 마킹', 'A', '100', true, 88000, 'BOTH' UNION ALL
    SELECT 39, 'KT 위즈', '2023 홈', 'B', '95', false, 40000, 'DELIVERY' UNION ALL
    SELECT 40, 'KT 위즈', '레트로 유니폼', 'A', '100', false, 62000, 'DELIVERY' UNION ALL
    SELECT 41, '한화 이글스', '2024 홈', 'S', '105', false, 75000, 'DELIVERY' UNION ALL
    SELECT 42, '한화 이글스', '류현진 마킹', 'S', '100', true, 220000, 'DELIVERY' UNION ALL
    SELECT 43, '한화 이글스', '레트로 베어스', 'A', '95', false, 68000, 'BOTH' UNION ALL
    SELECT 44, '한화 이글스', '2023 어웨이', 'B', '105', false, 38000, 'DELIVERY' UNION ALL
    SELECT 45, '한화 이글스', '채은성 마킹', 'A', '100', true, 85000, 'DELIVERY' UNION ALL
    SELECT 46, '키움 히어로즈', '2024 홈', 'S', '100', false, 72000, 'DELIVERY' UNION ALL
    SELECT 47, '키움 히어로즈', '이정후 마킹', 'S', '105', true, 190000, 'DELIVERY' UNION ALL
    SELECT 48, '키움 히어로즈', '2022 홈', 'A', '95', false, 58000, 'BOTH' UNION ALL
    SELECT 49, '키움 히어로즈', '레트로 히어로즈', 'B', '100', false, 35000, 'DELIVERY' UNION ALL
    SELECT 50, '키움 히어로즈', '안우진 마킹', 'A', '105', true, 82000, 'DELIVERY' UNION ALL
    SELECT 51, 'KIA 타이거즈', '2024 플레이오프', 'S', '100', false, 130000, 'DELIVERY' UNION ALL
    SELECT 52, '삼성 라이온즈', '2024 플레이오프', 'A', '105', false, 75000, 'DELIVERY' UNION ALL
    SELECT 53, 'LG 트윈스', '2024 플레이오프', 'S', '100', true, 140000, 'DELIVERY' UNION ALL
    SELECT 54, '두산 베어스', '2024 플레이오프', 'A', '95', false, 72000, 'BOTH' UNION ALL
    SELECT 55, 'SSG 랜더스', '2024 플레이오프', 'S', '105', false, 115000, 'DELIVERY' UNION ALL
    SELECT 56, 'KIA 타이거즈', '2023 어웨이', 'B', '100', false, 38000, 'DELIVERY' UNION ALL
    SELECT 57, '삼성 라이온즈', '2022 홈', 'A', '95', true, 55000, 'BOTH' UNION ALL
    SELECT 58, 'LG 트윈스', '2022 홈', 'B', '105', false, 40000, 'DELIVERY' UNION ALL
    SELECT 59, '두산 베어스', '2022 어웨이', 'A', '100', false, 60000, 'DELIVERY' UNION ALL
    SELECT 60, '롯데 자이언츠', '2022 홈', 'B', '95', true, 35000, 'DELIVERY' UNION ALL
    SELECT 61, 'NC 다이노스', '2022 홈', 'A', '105', false, 58000, 'BOTH' UNION ALL
    SELECT 62, 'KT 위즈', '2022 어웨이', 'S', '100', false, 78000, 'DELIVERY' UNION ALL
    SELECT 63, '한화 이글스', '2022 홈', 'B', '95', false, 32000, 'DELIVERY' UNION ALL
    SELECT 64, '키움 히어로즈', '2022 어웨이', 'A', '105', true, 62000, 'DELIVERY' UNION ALL
    SELECT 65, 'KIA 타이거즈', '팬 에디션', 'S', '100', false, 95000, 'BOTH' UNION ALL
    SELECT 66, '삼성 라이온즈', '팬 에디션', 'A', '95', false, 72000, 'DELIVERY' UNION ALL
    SELECT 67, 'LG 트윈스', '팬 에디션', 'S', '105', true, 110000, 'DELIVERY' UNION ALL
    SELECT 68, '두산 베어스', '팬 에디션', 'A', '100', false, 68000, 'DELIVERY' UNION ALL
    SELECT 69, 'SSG 랜더스', '팬 에디션', 'S', '95', false, 98000, 'BOTH' UNION ALL
    SELECT 70, '롯데 자이언츠', '팬 에디션', 'B', '105', false, 42000, 'DELIVERY' UNION ALL
    SELECT 71, 'KIA 타이거즈', '오드리 홈', 'A', '100', true, 78000, 'DELIVERY' UNION ALL
    SELECT 72, '삼성 라이온즈', '블루 어웨이', 'S', '95', false, 88000, 'DELIVERY' UNION ALL
    SELECT 73, 'LG 트윈스', '블랙 에디션', 'A', '105', false, 72000, 'BOTH' UNION ALL
    SELECT 74, '두산 베어스', '곰돌이 에디션', 'B', '100', false, 38000, 'DELIVERY' UNION ALL
    SELECT 75, 'NC 다이노스', '다크 에디션', 'S', '95', true, 92000, 'DELIVERY' UNION ALL
    SELECT 76, 'KT 위즈', '레드 에디션', 'A', '105', false, 65000, 'DELIVERY' UNION ALL
    SELECT 77, '한화 이글스', '이글스 클래식', 'S', '100', false, 82000, 'BOTH' UNION ALL
    SELECT 78, '키움 히어로즈', '히어로즈 클래식', 'A', '95', true, 75000, 'DELIVERY' UNION ALL
    SELECT 79, 'KIA 타이거즈', '호랑이 에디션', 'B', '105', false, 35000, 'DELIVERY' UNION ALL
    SELECT 80, '삼성 라이온즈', '라이온 클래식', 'S', '100', false, 95000, 'DELIVERY' UNION ALL
    SELECT 81, 'LG 트윈스', '트윈스 클래식', 'A', '95', false, 70000, 'BOTH' UNION ALL
    SELECT 82, '두산 베어스', '베어스 레트로', 'B', '105', true, 40000, 'DELIVERY' UNION ALL
    SELECT 83, 'SSG 랜더스', '랜더스 스페셜', 'S', '100', false, 105000, 'DELIVERY' UNION ALL
    SELECT 84, '롯데 자이언츠', '자이언츠 클래식', 'A', '95', false, 68000, 'DELIVERY' UNION ALL
    SELECT 85, 'NC 다이노스', '다이노스 스페셜', 'S', '105', true, 98000, 'BOTH' UNION ALL
    SELECT 86, 'KT 위즈', '위즈 스페셜', 'A', '100', false, 72000, 'DELIVERY' UNION ALL
    SELECT 87, '한화 이글스', '이글스 스페셜', 'B', '95', false, 38000, 'DELIVERY' UNION ALL
    SELECT 88, '키움 히어로즈', '히어로즈 스페셜', 'S', '105', true, 88000, 'DELIVERY' UNION ALL
    SELECT 89, 'KIA 타이거즈', '2021 홈', 'A', '100', false, 58000, 'BOTH' UNION ALL
    SELECT 90, '삼성 라이온즈', '2021 홈', 'B', '95', false, 35000, 'DELIVERY' UNION ALL
    SELECT 91, 'LG 트윈스', '2021 홈', 'A', '105', true, 62000, 'DELIVERY' UNION ALL
    SELECT 92, '두산 베어스', '2021 홈', 'S', '100', false, 82000, 'DELIVERY' UNION ALL
    SELECT 93, 'SSG 랜더스', '2021 홈', 'A', '95', false, 65000, 'BOTH' UNION ALL
    SELECT 94, '롯데 자이언츠', '2021 홈', 'B', '105', false, 32000, 'DELIVERY' UNION ALL
    SELECT 95, 'NC 다이노스', '2021 홈', 'S', '100', true, 92000, 'DELIVERY' UNION ALL
    SELECT 96, 'KT 위즈', '2021 홈', 'A', '95', false, 68000, 'DELIVERY' UNION ALL
    SELECT 97, '한화 이글스', '2021 홈', 'B', '105', false, 35000, 'BOTH' UNION ALL
    SELECT 98, '키움 히어로즈', '2021 홈', 'A', '100', true, 72000, 'DELIVERY' UNION ALL
    SELECT 99, 'KIA 타이거즈', '챔피언스 에디션', 'S', '95', false, 125000, 'DELIVERY' UNION ALL
    SELECT 100, '삼성 라이온즈', '챔피언스 에디션', 'S', '105', true, 135000, 'DELIVERY'
    ) AS data ON 1=1
    LIMIT 100;

-- 2) SOCCER (80개)
INSERT INTO post (seller_id, title, content, sport, team, uniform_name, grade, size, marking, price, delivery_type, status, view_count, wish_count, created_at, updated_at)
SELECT
    m.member_id,
    CONCAT(team_name, ' ', uniform_name, ' 유니폼 팝니다'),
    CONCAT('상태 ', grade, '급 유니폼입니다. 착용감 좋고 보관 잘 했습니다. 택배 거래 가능합니다.'),
    'SOCCER',
    team_name,
    uniform_name,
    grade,
    size,
    marking,
    price,
    delivery_type,
    'ON_SALE',
    FLOOR(RAND() * 500),
    FLOOR(RAND() * 80),
    DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 60) DAY),
    DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 60) DAY)
FROM (
    SELECT * FROM (
    SELECT m.member_id FROM member m WHERE email LIKE 'user%@reform.com' ORDER BY RAND()
    ) AS shuffled
    LIMIT 80
    ) AS m
    JOIN (
    SELECT 1 AS idx, '토트넘' AS team_name, '23/24 홈' AS uniform_name, 'S' AS grade, '105' AS size, false AS marking, 85000 AS price, 'DELIVERY' AS delivery_type UNION ALL
    SELECT 2, '토트넘', '23/24 어웨이', 'A', '100', true, 72000, 'DELIVERY' UNION ALL
    SELECT 3, '토트넘', '손흥민 마킹 홈', 'S', '105', true, 150000, 'DELIVERY' UNION ALL
    SELECT 4, '토트넘', '22/23 홈', 'B', '95', false, 45000, 'BOTH' UNION ALL
    SELECT 5, '토트넘', '21/22 홈', 'A', '100', false, 60000, 'DELIVERY' UNION ALL
    SELECT 6, 'PSG', '23/24 홈', 'S', '105', false, 95000, 'DELIVERY' UNION ALL
    SELECT 7, 'PSG', '이강인 마킹', 'S', '100', true, 180000, 'DELIVERY' UNION ALL
    SELECT 8, 'PSG', '23/24 어웨이', 'A', '95', false, 78000, 'BOTH' UNION ALL
    SELECT 9, 'PSG', '22/23 홈', 'B', '105', false, 48000, 'DELIVERY' UNION ALL
    SELECT 10, 'PSG', '음바페 마킹', 'S', '100', true, 200000, 'DELIVERY' UNION ALL
    SELECT 11, '맨체스터 시티', '23/24 홈', 'S', '105', false, 92000, 'DELIVERY' UNION ALL
    SELECT 12, '맨체스터 시티', '홀란드 마킹', 'S', '100', true, 175000, 'DELIVERY' UNION ALL
    SELECT 13, '맨체스터 시티', '23/24 어웨이', 'A', '95', false, 75000, 'BOTH' UNION ALL
    SELECT 14, '맨체스터 시티', '22/23 홈', 'B', '105', false, 48000, 'DELIVERY' UNION ALL
    SELECT 15, '맨체스터 시티', '데브라위너 마킹', 'A', '100', true, 110000, 'DELIVERY' UNION ALL
    SELECT 16, '레알 마드리드', '23/24 홈', 'S', '105', false, 98000, 'DELIVERY' UNION ALL
    SELECT 17, '레알 마드리드', '벨링엄 마킹', 'S', '100', true, 185000, 'DELIVERY' UNION ALL
    SELECT 18, '레알 마드리드', '23/24 어웨이', 'A', '95', false, 82000, 'BOTH' UNION ALL
    SELECT 19, '레알 마드리드', '비니시우스 마킹', 'A', '105', true, 125000, 'DELIVERY' UNION ALL
    SELECT 20, '레알 마드리드', '22/23 홈', 'B', '100', false, 52000, 'DELIVERY' UNION ALL
    SELECT 21, 'FC 바르셀로나', '23/24 홈', 'S', '105', false, 95000, 'DELIVERY' UNION ALL
    SELECT 22, 'FC 바르셀로나', '야말 마킹', 'S', '100', true, 170000, 'DELIVERY' UNION ALL
    SELECT 23, 'FC 바르셀로나', '23/24 어웨이', 'A', '95', false, 78000, 'BOTH' UNION ALL
    SELECT 24, 'FC 바르셀로나', '레반도프스키 마킹', 'A', '105', true, 115000, 'DELIVERY' UNION ALL
    SELECT 25, 'FC 바르셀로나', '22/23 홈', 'B', '100', false, 50000, 'DELIVERY' UNION ALL
    SELECT 26, '맨체스터 유나이티드', '23/24 홈', 'S', '105', false, 88000, 'DELIVERY' UNION ALL
    SELECT 27, '맨체스터 유나이티드', '라쉬포드 마킹', 'A', '100', true, 105000, 'DELIVERY' UNION ALL
    SELECT 28, '맨체스터 유나이티드', '23/24 어웨이', 'B', '95', false, 48000, 'BOTH' UNION ALL
    SELECT 29, '맨체스터 유나이티드', '22/23 홈', 'A', '105', false, 68000, 'DELIVERY' UNION ALL
    SELECT 30, '맨체스터 유나이티드', '루니 레전드', 'S', '100', true, 220000, 'DELIVERY' UNION ALL
    SELECT 31, '리버풀', '23/24 홈', 'S', '105', false, 90000, 'DELIVERY' UNION ALL
    SELECT 32, '리버풀', '살라 마킹', 'S', '100', true, 165000, 'DELIVERY' UNION ALL
    SELECT 33, '리버풀', '23/24 어웨이', 'A', '95', false, 75000, 'BOTH' UNION ALL
    SELECT 34, '리버풀', '누녜스 마킹', 'A', '105', true, 110000, 'DELIVERY' UNION ALL
    SELECT 35, '리버풀', '22/23 홈', 'B', '100', false, 48000, 'DELIVERY' UNION ALL
    SELECT 36, '바이에른 뮌헨', '23/24 홈', 'S', '105', false, 92000, 'DELIVERY' UNION ALL
    SELECT 37, '바이에른 뮌헨', '케인 마킹', 'S', '100', true, 170000, 'DELIVERY' UNION ALL
    SELECT 38, '바이에른 뮌헨', '23/24 어웨이', 'A', '95', false, 78000, 'BOTH' UNION ALL
    SELECT 39, '바이에른 뮌헨', '뮐러 마킹', 'A', '105', true, 108000, 'DELIVERY' UNION ALL
    SELECT 40, '바이에른 뮌헨', '22/23 홈', 'B', '100', false, 50000, 'DELIVERY' UNION ALL
    SELECT 41, '첼시', '23/24 홈', 'S', '105', false, 85000, 'DELIVERY' UNION ALL
    SELECT 42, '첼시', '팔머 마킹', 'S', '100', true, 155000, 'DELIVERY' UNION ALL
    SELECT 43, '첼시', '23/24 어웨이', 'A', '95', false, 70000, 'BOTH' UNION ALL
    SELECT 44, '첼시', '22/23 홈', 'B', '105', false, 45000, 'DELIVERY' UNION ALL
    SELECT 45, '첼시', '드로그바 레전드', 'S', '100', true, 200000, 'DELIVERY' UNION ALL
    SELECT 46, '아스날', '23/24 홈', 'S', '105', false, 88000, 'DELIVERY' UNION ALL
    SELECT 47, '아스날', '사카 마킹', 'S', '100', true, 160000, 'DELIVERY' UNION ALL
    SELECT 48, '아스날', '23/24 어웨이', 'A', '95', false, 72000, 'BOTH' UNION ALL
    SELECT 49, '아스날', '22/23 홈', 'B', '105', false, 46000, 'DELIVERY' UNION ALL
    SELECT 50, '아스날', '외데고르 마킹', 'A', '100', true, 112000, 'DELIVERY' UNION ALL
    SELECT 51, '전북 현대', '2024 홈', 'S', '105', false, 72000, 'DELIVERY' UNION ALL
    SELECT 52, '전북 현대', '2024 어웨이', 'A', '100', false, 58000, 'BOTH' UNION ALL
    SELECT 53, '전북 현대', '2023 홈', 'B', '95', true, 38000, 'DELIVERY' UNION ALL
    SELECT 54, '울산 HD', '2024 홈', 'S', '105', false, 68000, 'DELIVERY' UNION ALL
    SELECT 55, '울산 HD', '2024 어웨이', 'A', '100', false, 55000, 'BOTH' UNION ALL
    SELECT 56, '수원 삼성', '2024 홈', 'A', '95', false, 62000, 'DELIVERY' UNION ALL
    SELECT 57, '수원 삼성', '레트로 홈', 'S', '105', true, 120000, 'DELIVERY' UNION ALL
    SELECT 58, 'FC 서울', '2024 홈', 'S', '100', false, 70000, 'DELIVERY' UNION ALL
    SELECT 59, 'FC 서울', '2024 어웨이', 'A', '95', false, 58000, 'BOTH' UNION ALL
    SELECT 60, 'FC 서울', '레트로 홈', 'B', '105', false, 35000, 'DELIVERY' UNION ALL
    SELECT 61, '인천 유나이티드', '2024 홈', 'A', '100', false, 60000, 'DELIVERY' UNION ALL
    SELECT 62, '대구 FC', '2024 홈', 'S', '95', true, 75000, 'DELIVERY' UNION ALL
    SELECT 63, '포항 스틸러스', '2024 홈', 'A', '105', false, 62000, 'BOTH' UNION ALL
    SELECT 64, '성남 FC', '레트로 홈', 'S', '100', false, 95000, 'DELIVERY' UNION ALL
    SELECT 65, '수원 FC', '2024 홈', 'B', '95', false, 38000, 'DELIVERY' UNION ALL
    SELECT 66, '토트넘', '챔피언스리그 에디션', 'S', '105', true, 140000, 'DELIVERY' UNION ALL
    SELECT 67, 'PSG', '챔피언스리그 에디션', 'S', '100', false, 135000, 'DELIVERY' UNION ALL
    SELECT 68, '맨체스터 시티', '챔피언스리그 우승', 'S', '105', true, 250000, 'DELIVERY' UNION ALL
    SELECT 69, '레알 마드리드', '챔피언스리그 에디션', 'S', '100', false, 145000, 'BOTH' UNION ALL
    SELECT 70, 'FC 바르셀로나', '챔피언스리그 에디션', 'A', '95', false, 98000, 'DELIVERY' UNION ALL
    SELECT 71, '토트넘', '20/21 홈', 'B', '105', false, 40000, 'DELIVERY' UNION ALL
    SELECT 72, 'PSG', '21/22 홈', 'A', '100', true, 72000, 'DELIVERY' UNION ALL
    SELECT 73, '맨체스터 시티', '21/22 홈', 'B', '95', false, 45000, 'BOTH' UNION ALL
    SELECT 74, '레알 마드리드', '21/22 홈', 'A', '105', false, 78000, 'DELIVERY' UNION ALL
    SELECT 75, 'FC 바르셀로나', '21/22 홈', 'B', '100', false, 42000, 'DELIVERY' UNION ALL
    SELECT 76, '리버풀', '20/21 홈', 'A', '95', true, 68000, 'BOTH' UNION ALL
    SELECT 77, '바이에른 뮌헨', '21/22 홈', 'B', '105', false, 45000, 'DELIVERY' UNION ALL
    SELECT 78, '첼시', '21/22 홈', 'A', '100', false, 62000, 'DELIVERY' UNION ALL
    SELECT 79, '아스날', '20/21 홈', 'B', '95', false, 38000, 'BOTH' UNION ALL
    SELECT 80, '맨체스터 유나이티드', '20/21 홈', 'A', '105', true, 65000, 'DELIVERY'
    ) AS data ON 1=1
    LIMIT 80;

-- 3) BASKETBALL (50개)
INSERT INTO post (seller_id, title, content, sport, team, uniform_name, grade, size, marking, price, delivery_type, status, view_count, wish_count, created_at, updated_at)
SELECT
    m.member_id,
    CONCAT(team_name, ' ', uniform_name, ' 유니폼 팝니다'),
    CONCAT('상태 ', grade, '급 유니폼입니다. 착용감 좋고 보관 잘 했습니다. 택배 거래 가능합니다.'),
    'BASKETBALL',
    team_name,
    uniform_name,
    grade,
    size,
    marking,
    price,
    delivery_type,
    'ON_SALE',
    FLOOR(RAND() * 200),
    FLOOR(RAND() * 40),
    DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 60) DAY),
    DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 60) DAY)
FROM (
    SELECT * FROM (
    SELECT m.member_id FROM member m WHERE email LIKE 'user%@reform.com' ORDER BY RAND()
    ) AS shuffled
    LIMIT 50
    ) AS m
    JOIN (
    SELECT 1 AS idx, '서울 SK 나이츠' AS team_name, '2024 홈' AS uniform_name, 'S' AS grade, '105' AS size, false AS marking, 72000 AS price, 'DELIVERY' AS delivery_type UNION ALL
    SELECT 2, '서울 SK 나이츠', '2024 어웨이', 'A', '100', false, 58000, 'BOTH' UNION ALL
    SELECT 3, '서울 SK 나이츠', '2023 챔피언스', 'S', '95', true, 130000, 'DELIVERY' UNION ALL
    SELECT 4, '서울 삼성 썬더스', '2024 홈', 'A', '105', false, 65000, 'DELIVERY' UNION ALL
    SELECT 5, '서울 삼성 썬더스', '2024 어웨이', 'S', '100', false, 78000, 'BOTH' UNION ALL
    SELECT 6, '원주 DB 프로미', '2024 홈', 'S', '95', true, 85000, 'DELIVERY' UNION ALL
    SELECT 7, '원주 DB 프로미', '우승 에디션', 'S', '105', false, 125000, 'DELIVERY' UNION ALL
    SELECT 8, '원주 DB 프로미', '2023 홈', 'B', '100', false, 38000, 'BOTH' UNION ALL
    SELECT 9, '수원 KT 소닉붐', '2024 홈', 'A', '95', false, 60000, 'DELIVERY' UNION ALL
    SELECT 10, '수원 KT 소닉붐', '2024 어웨이', 'S', '105', true, 88000, 'DELIVERY' UNION ALL
    SELECT 11, '안양 정관장', '2024 홈', 'S', '100', false, 75000, 'DELIVERY' UNION ALL
    SELECT 12, '안양 정관장', '2024 어웨이', 'A', '95', false, 62000, 'BOTH' UNION ALL
    SELECT 13, '울산 현대모비스', '2024 홈', 'S', '105', true, 82000, 'DELIVERY' UNION ALL
    SELECT 14, '울산 현대모비스', '우승 에디션', 'S', '100', false, 150000, 'DELIVERY' UNION ALL
    SELECT 15, '고양 소노', '2024 홈', 'A', '95', false, 58000, 'BOTH' UNION ALL
    SELECT 16, '부산 KCC 이지스', '2024 홈', 'S', '105', false, 78000, 'DELIVERY' UNION ALL
    SELECT 17, '부산 KCC 이지스', '허재 레전드', 'S', '100', true, 200000, 'DELIVERY' UNION ALL
    SELECT 18, '창원 LG 세이커스', '2024 홈', 'A', '95', false, 62000, 'BOTH' UNION ALL
    SELECT 19, '전주 KCC 이지스', '레트로 유니폼', 'S', '105', false, 95000, 'DELIVERY' UNION ALL
    SELECT 20, 'LA 레이커스', '르브론 마킹', 'S', '100', true, 220000, 'DELIVERY' UNION ALL
    SELECT 21, 'LA 레이커스', '2024 홈', 'S', '95', false, 120000, 'DELIVERY' UNION ALL
    SELECT 22, 'LA 레이커스', '코비 레전드', 'S', '105', true, 350000, 'DELIVERY' UNION ALL
    SELECT 23, 'LA 레이커스', '앤서니 데이비스', 'A', '100', true, 135000, 'BOTH' UNION ALL
    SELECT 24, '골든스테이트 워리어스', '커리 마킹', 'S', '95', true, 210000, 'DELIVERY' UNION ALL
    SELECT 25, '골든스테이트 워리어스', '2024 홈', 'S', '105', false, 115000, 'DELIVERY' UNION ALL
    SELECT 26, '보스턴 셀틱스', '2024 홈', 'S', '100', false, 112000, 'DELIVERY' UNION ALL
    SELECT 27, '보스턴 셀틱스', '테이텀 마킹', 'S', '95', true, 195000, 'DELIVERY' UNION ALL
    SELECT 28, '마이애미 히트', '지미 버틀러', 'A', '105', true, 148000, 'BOTH' UNION ALL
    SELECT 29, '시카고 불스', '조던 레전드', 'S', '100', true, 450000, 'DELIVERY' UNION ALL
    SELECT 30, '시카고 불스', '2024 홈', 'A', '95', false, 98000, 'DELIVERY' UNION ALL
    SELECT 31, '밀워키 벅스', '야니스 마킹', 'S', '105', true, 188000, 'DELIVERY' UNION ALL
    SELECT 32, '덴버 너기츠', '요키치 마킹', 'S', '100', true, 185000, 'BOTH' UNION ALL
    SELECT 33, '덴버 너기츠', '2024 홈', 'A', '95', false, 105000, 'DELIVERY' UNION ALL
    SELECT 34, '피닉스 선즈', '듀란트 마킹', 'S', '105', true, 192000, 'DELIVERY' UNION ALL
    SELECT 35, '달라스 매버릭스', '돈치치 마킹', 'S', '100', true, 205000, 'DELIVERY' UNION ALL
    SELECT 36, '서울 SK 나이츠', '레트로 유니폼', 'S', '95', false, 98000, 'BOTH' UNION ALL
    SELECT 37, '원주 DB 프로미', '레트로 유니폼', 'A', '105', true, 78000, 'DELIVERY' UNION ALL
    SELECT 38, '안양 정관장', '레트로 유니폼', 'S', '100', false, 92000, 'DELIVERY' UNION ALL
    SELECT 39, 'LA 레이커스', '쇼타임 레트로', 'S', '95', false, 180000, 'DELIVERY' UNION ALL
    SELECT 40, '골든스테이트 워리어스', '레트로 유니폼', 'A', '105', false, 125000, 'BOTH' UNION ALL
    SELECT 41, '서울 SK 나이츠', '2022 홈', 'B', '100', false, 35000, 'DELIVERY' UNION ALL
    SELECT 42, '울산 현대모비스', '2022 홈', 'A', '95', true, 65000, 'DELIVERY' UNION ALL
    SELECT 43, '부산 KCC 이지스', '2022 홈', 'B', '105', false, 38000, 'BOTH' UNION ALL
    SELECT 44, '보스턴 셀틱스', '2022 홈', 'A', '100', false, 102000, 'DELIVERY' UNION ALL
    SELECT 45, '마이애미 히트', '2022 홈', 'S', '95', true, 115000, 'DELIVERY' UNION ALL
    SELECT 46, '서울 삼성 썬더스', '레트로 유니폼', 'S', '105', false, 88000, 'DELIVERY' UNION ALL
    SELECT 47, '수원 KT 소닉붐', '레트로 유니폼', 'A', '100', false, 72000, 'BOTH' UNION ALL
    SELECT 48, '밀워키 벅스', '2022 홈', 'S', '95', true, 128000, 'DELIVERY' UNION ALL
    SELECT 49, '달라스 매버릭스', '노비츠키 레전드', 'S', '105', true, 280000, 'DELIVERY' UNION ALL
    SELECT 50, '피닉스 선즈', '2022 홈', 'A', '100', false, 98000, 'DELIVERY'
    ) AS data ON 1=1
    LIMIT 50;

-- 4) ESPORTS (10개)
INSERT INTO post (seller_id, title, content, sport, team, uniform_name, grade, size, marking, price, delivery_type, status, view_count, wish_count, created_at, updated_at)
SELECT
    m.member_id,
    CONCAT(team_name, ' ', uniform_name, ' 유니폼 팝니다'),
    CONCAT('상태 ', grade, '급 유니폼입니다. 착용감 좋고 보관 잘 했습니다. 택배 거래 가능합니다.'),
    'ESPORTS',
    team_name,
    uniform_name,
    grade,
    size,
    marking,
    price,
    delivery_type,
    'ON_SALE',
    FLOOR(RAND() * 400),
    FLOOR(RAND() * 60),
    DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 60) DAY),
    DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 60) DAY)
FROM (
    SELECT * FROM (
    SELECT m.member_id FROM member m WHERE email LIKE 'user%@reform.com' ORDER BY RAND()
    ) AS shuffled
    LIMIT 10
    ) AS m
    JOIN (
    SELECT 1 AS idx, 'T1' AS team_name, '2024 월드챔피언십' AS uniform_name, 'S' AS grade, '105' AS size, false AS marking, 150000 AS price, 'DELIVERY' AS delivery_type UNION ALL
    SELECT 2, 'T1', '페이커 마킹', 'S', '100', true, 350000, 'DELIVERY' UNION ALL
    SELECT 3, 'T1', '2023 월드챔피언십', 'S', '95', false, 180000, 'DELIVERY' UNION ALL
    SELECT 4, 'Gen.G', '2024 홈', 'S', '105', false, 120000, 'DELIVERY' UNION ALL
    SELECT 5, 'Gen.G', '쵸비 마킹', 'A', '100', true, 185000, 'BOTH' UNION ALL
    SELECT 6, 'KT 롤스터', '2024 홈', 'S', '95', false, 115000, 'DELIVERY' UNION ALL
    SELECT 7, 'DRX', '2022 월드챔피언십', 'S', '105', true, 250000, 'DELIVERY' UNION ALL
    SELECT 8, '한화생명e스포츠', '2024 홈', 'A', '100', false, 95000, 'DELIVERY' UNION ALL
    SELECT 9, '농심 레드포스', '2024 홈', 'B', '95', false, 65000, 'BOTH' UNION ALL
    SELECT 10, 'T1', '2022 월드챔피언십', 'S', '105', true, 300000, 'DELIVERY'
    ) AS data ON 1=1
    LIMIT 10;