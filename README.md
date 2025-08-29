# ⚡ Battery Monitoring System

전기차, 지게차, AGV 등의 **배터리 상태와 장비 정보를 모니터링**하는 웹 기반 관리 시스템.  
Spring Boot + MyBatis + MySQL 기반 API 서버.

---

## 📑 주요 API 기능

### 🏠 Home 대시보드 조회
- **Endpoint**: `GET /api/home`
- **기능**:
  - 목표량, 완성품량, 불량품량, 총 생산량 조회
  - 장비별 주의/경고 상태 수
  - 공장별 평균 배터리량

---

### ⚙️ Equipment 리스트 조회
- **Endpoint**:
  - `/api/equipments/{equipment_id}/factory/{factory_id}?status=good&page=0&size=6`
  - `/api/equipments/{equipment_id}/factory/{factory_id}?status=warning&page=0&size=6`
  - `/api/equipments/{equipment_id}/factory/{factory_id}?status=danger&page=0&size=6`
- **기능**:
  - 공장별 장비 리스트 조회
  - 상태별(Good/Warning/Danger) 필터링
  - 페이징 처리 지원

---

### 🔎 Equipment 상세 조회
- **Endpoint**: `GET /api/equipments/{model_infos_id}`
- **기능**:
  - 특정 장비의 상세 데이터 조회
  - 이동 이력(`fromLoc`, `toLoc`), 상태(`status`), 거리(`distance`), 사이클(`cycle`)
  - 로그(`tempLogs`) 포함

---

## 📊 응답 예시

```json
{
  "equipmentId": 1,
  "modelNum": "AGV-001",
  "status": "Charge",
  "distance": 1121.39,
  "tempLogs": [
    [-8.5, "2025-08-29T09:47:10"]
  ]
}
