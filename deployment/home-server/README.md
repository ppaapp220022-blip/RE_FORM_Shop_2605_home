# Home Server Deployment

이 디렉터리는 `RE_FORM_Shop_2605_home` 백엔드와 `reform-view-home` 프론트를 한 도메인으로 운영하기 위한 홈서버 배포 기준 파일입니다.

## 구조

- 외부 공개 도메인: `https://reform.example.com`
- Nginx Proxy Manager:
  - Forward Hostname/IP: `127.0.0.1`
  - Forward Port: `3000`
- frontend 컨테이너 nginx:
  - `/` -> 정적 프론트
  - `/api`, `/oauth2`, `/login/oauth2`, `/uploads`, `/stomp` -> backend

## 준비

1. 서버에 배포 경로 생성
2. `.env.example`를 `.env`로 복사 후 실제 값 입력
3. `docker compose up -d`

예시:

```bash
mkdir -p /srv/docker/reform
cp deployment/home-server/docker-compose.yml /srv/docker/reform/docker-compose.yml
cp deployment/home-server/.env.example /srv/docker/reform/.env
cd /srv/docker/reform
docker compose --env-file .env up -d
```
