![logo](https://github.com/wanted-quantum-jump/FoodieFinder/assets/46921979/9a5c8985-b571-4df5-9f9a-3c078cbbd014)

# FoodieFinder - 지리기반 맛집 추천 웹 서비스

<br>

<div align="center">
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Spring Boot 3.1.5-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Spring Data JPA-gray?style=for-the-badge&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Junit-25A162?style=for-the-badge&logo=JUnit5&logoColor=white"/></a>
</div>
<div align="center">
<img src="https://img.shields.io/badge/MySQL 8-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"/></a>
<img src="https://img.shields.io/static/v1?style=for-the-badge&message=Redis&color=DC382D&logo=Redis&logoColor=FFFFFF&label=" alt="Redis">
<img src="https://img.shields.io/static/v1?style=for-the-badge&message=Amazon+EC2&color=222222&logo=Amazon+EC2&logoColor=FF9900&label=" alt="Amazon EC2">
<img src="https://img.shields.io/static/v1?style=for-the-badge&message=Amazon+RDS&color=527FFF&logo=Amazon+RDS&logoColor=FFFFFF&label=" alt="Amazon RDS">
</div>
<div align="center">
<img src="https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Notion-FFFFFF?style=for-the-badge&logo=Notion&logoColor=black"/></a>
<img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/></a>
</div>

<br>

FoodieFinder는 공공데이터를 활용하여, 지역 음식점 목록을 자동으로 업데이트 하고 이를 활용합니다. `사용자 위치` 에맞게 맛집 및 메뉴를 추천하여 더 나은 `다양한 음식 경험`을 제공하고, 음식을 좋아하는
사람들 간의 소통과
공유를 촉진하려 합니다.
<br>
<br>
<div align="center">

## ☄️ Team Q members

<table>
    <tr>
        <th>김서윤</th>
        <th>방성원</th>
        <th>장혜리</th>
        <th>정지원</th>
    </tr>
    <tr>
        <td><a href="https://github.com/seoyoon047">@seoyoon047</a></td>
        <td><a href="https://github.com/O0oO0Oo">@O0oO0Oo</a></td>
        <td><a href="https://github.com/hyerijang">@hyerijang</a></td>
        <td><a href="https://github.com/cjw9506">@cjw9506</a></td>
    </tr>
</table>
</div>


## 0. 목차
- [1.개발 기간](#1-개발-기간)
- [2.프로젝트 요구사항](#2-프로젝트-요구사항)
- [3.담당 역할](#3-담당-역할)
- [4.프로젝트 구조](#4-프로젝트-구조)
- [5.ERD](#5-erd)
- [6.동작예시](#6-동작예시)
- [7.API 문서](#7-api-document)
- [8.프로젝트 스케줄링](#8-프로젝트-스케줄링)
- [9.노력한 점](#9-노력한-점)
- [10.구현 과정 (설계 및 의도)](#10-구현-과정-설계-및-의도)

## 1. 개발 기간

2023.10.31 ~ 2023.11.08  (9 days)

## 2. 프로젝트 요구사항


### 유저스토리

- 유저는 본 사이트에 들어와 회원가입 및 내 위치를 지정한다.
- **A. 내 위치 기반 맛집추천 = (`내 주변보기`)**
    - `도보` 기준 `1km` 이내의 맛집을 추천한다.
    - `교통수단` 기준 `5km` 이내의 맛집을 추천한다.
- **B. 지역명 기준 맛집추천(`특정 지역 보기`)**
    - 지정한 `지명(시군구)` 중심위치 기준 `10km` 이내의 맛집을 추천한다.
- **C. 점심 추천 서비스**
    - 점심 추천 서비스 이용을 승락한 대상에게 매일 정오, 대상의 위치를 기준으로 원하는 유형(일식, 중식 등)의 가게를 3개씩 추천 해준다.
- A, B는 다양한 검색기준 (정렬, 필터링 등)으로 조회 가능하며 (`거리순`, `평점순` , `양식`, `중식`)
- 해당 맛집의 상세정보를 확인할 수 있다.

## 3. 담당 역할

<table>
    <tr>
        <td>김서윤</td>
        <td>시군구, 맛집 목록, 맛집 상세정보, 평가 API 구현</td>
    </tr>
    <tr>
        <td>방성원</td>
        <td>데이터 수집, 데이터 전처리, 자동화 구현 및 Redis 캐싱</td>
    </tr>
    <tr>
        <td>장혜리</td>
        <td>데이터 전처리, 데이터 저장, 디스코드 점심 추천 서비스 구현</td>
    </tr>
    <tr>
        <td>정지원</td>
        <td>사용자 관련 서비스 및 인증, 인가 구현</td>
    </tr>
</table>

## 4. 프로젝트 구조

<details>
    <summary>자세히</summary>

#### main
```
├─main
│  ├─java
│  │  └─com
│  │      └─foodiefinder
│  │          ├─auth
│  │          │  ├─config
│  │          │  ├─controller
│  │          │  ├─dto
│  │          │  ├─filter
│  │          │  ├─jwt
│  │          │  └─service
│  │          ├─cities
│  │          │  ├─controller
│  │          │  │  └─response
│  │          │  ├─domain
│  │          │  ├─factory
│  │          │  └─service
│  │          ├─common
|  |          |  ├─cache
│  │          │  ├─config
│  │          │  ├─dto
│  │          │  ├─entity
|  |          |  ├─enums
│  │          │  └─exception
│  │          ├─datapipeline
|  |          |  ├─cache
│  │          │  ├─config
│  │          │  ├─enums
│  │          │  ├─job
│  │          │  ├─processor
│  │          │  │  └─dto
│  │          │  ├─reader
│  │          │  ├─step
│  │          │  ├─util
|  |          |  |  ├─hash
|  |          |  |  └─request
│  │          │  └─writer
│  │          │      ├─entity
│  │          │      └─repository
│  │          ├─notification
│  │          │  ├─dto
│  │          │  ├─scheduler
│  │          │  └─service
|  |          ├─restaurants
|  |          |  ├─cache
|  |          |  ├─controller
|  |          |  ├─dto
|  |          |  ├─entity
|  |          |  ├─enums
|  |          |  └─service
│  │          ├─settings
│  │          │  ├─controller
│  │          │  ├─dto
│  │          │  ├─entity
│  │          │  ├─repository
│  │          │  ├─service
│  │          │  └─valid
│  │          └─user
│  │              ├─controller
│  │              ├─crypto
│  │              ├─dto
│  │              ├─entity
│  │              ├─repository
│  │              └─service
│  └─resources
```

#### test
``` 
│─test
├─java
│  └─com
│      └─foodiefinder
│          ├─auth
│          │  ├─controller
│          │  └─service
│          ├─cities
│          ├─config
│          ├─datapipeline
│          │  ├─processor
│          │  ├─reader
│          │  ├─step
│          │  └─writer
│          │      └─repository
│          ├─notification
│          │  └─service
│          ├─settings
│          │  ├─controller
│          │  ├─service
│          │  └─valid
│          └─user
│              ├─controller
│              └─service
└─resources

```

</details>

## 5. ERD

<details>
    <summary>자세히</summary>

<img src="https://github.com/wanted-quantum-jump/FoodieFinder/assets/46921979/ff5974e4-0060-4e6d-9fcd-114e0b6eadd7" width="60%" />


</details>

## 6. 동작예시

### RDS
<img src="https://github.com/wanted-quantum-jump/FoodieFinder/assets/46921979/78288c73-15cc-4b73-adfe-e31bafb62708" width="60%" />
<img src="https://github.com/wanted-quantum-jump/FoodieFinder/assets/46921979/98e8fcb9-8abb-41c6-987d-ceba9676dbc3" width="60%" />


### 디스코드 점심 추천 서비스 예시

<img src="https://github.com/wanted-quantum-jump/FoodieFinder/assets/46921979/b468a807-76fb-4957-a647-6f23ae79ea0a" width="60%" />

## 7. API Document
최신 문서는 [FoodieFinder API Document](https://documenter.getpostman.com/view/13712893/2s9YXiY1Kv)를 참조해 주세요.

## 8. 프로젝트 스케줄링

### [Github Project](https://github.com/orgs/wanted-quantum-jump/projects/5)
![image](https://github.com/wanted-quantum-jump/FoodieFinder/assets/46921979/fa45837d-3362-4eff-901b-e42dc35c8319)

### [Team Q Notion - 일정관리 ](https://gifted-radiator-a91.notion.site/a0678da1b97a4cc6a3ade58ade37a304?v=d97f2cfce06e4abbb186dabc6d90bf55&pvs=4)
![image](https://github.com/wanted-quantum-jump/FoodieFinder/assets/46921979/e8a4282f-3702-4aac-9d47-fe776f6039a9)



## 9. 노력한 점 
**(장혜리)**
- 원활한 협업을 위해 엔티티 구현 등 다른 팀원의 업무에 필요한 부분(엔티티 등)은 우선적으로 구현하였습니다.
- 빠르고 상세한 코드 리뷰를 위해 노력하였습니다
    <details>
      <summary>코드 리뷰 예시 (자세히) </summary>
        
  [PR 예시](https://github.com/wanted-quantum-jump/FoodieFinder/pull/34)
  
  <img src="https://github.com/hyerijang/daily-pay/assets/46921979/7bcbcfe2-306d-47a9-90e7-2adf8d7b4b0e" width = "80%">
  
    </details>

- 단위 테스트 작성을 위해 노력하였습니다.
    <details>
      <summary>단위 테스트 예시 (자세히) </summary>
    <img src="https://github.com/hyerijang/FoodieFinder/assets/46921979/85dd6672-9332-46a8-8d80-e883affa438a" width = "80%">
    <img src="https://github.com/hyerijang/FoodieFinder/assets/46921979/4d42119d-4224-43f0-829f-f70ebfc6bdba" width = "80%">
    <img src="https://github.com/hyerijang/FoodieFinder/assets/46921979/6b25841d-91e7-47b2-a0a6-11204830e365" width = "80%">
  </details>

## 10. 구현 과정 (설계 및 의도)
**(장혜리)**

<details>
    <summary>데이터 전처리 및 저장</summary>

  - JSON 데이터를 가공하여 제가 구현한 Restaurant, Raw Restaurant 엔티티에 넣어 저장
  - **raw 데이터 테이블** - 특별한 변환이나 전처리 없이 String 그대로 저장
  - **실제 서비스에 이용되는 테이블** - raw 데이터 테이블에서 실제 사용되는 필드만 추리고, 데이터에 맞게 타입을 변경하여 저장
</details>
<details>
    <summary>디스코드 점심 추천 서비스</summary>

  - 디스코드 메시지 양식에 데이터를 가공 후, **매일 정오 유저가 등록해 둔 웹 훅 URL로 메시지를 발송**
  - **데이터 가공**
    - DB에서 맛집 정보를 조회할 때  Spring Data JPA의 **findAll**을 쓸 경우 경기도 전체의 식당 데이터를 가져오게 되어 심각한 **성능 저하**가 예상되었습니다.
    - 따라서 **유저를 중심**으로 한 **정사각형 영역의 꼭짓점**을 구하여 유저 인근 N 미터 이내의 식당 정보만 가져오도록 구현하였습니다.
  - **유저 점심 추천 알림을 설정할 수 있게 하는 API 구현**
    - **알림 설정 API**를 통해 유저는 어느정도 거리 내의 맛집을 추천받을지, 또 한식, 중식 등 어떤 유형의 음식점을 추천받을지 선택 가능
      -디스코드 메시지 발송
    - Quarz 스케줄러와 Webflux로 매일 정오 Nonblocking 하게 발송하도록 구현
      - **Quarz 스케줄러**의 경우 기존에 팀원분께서 데이터 수집에 이용하시던 부분을 그대로 차용해서 시간만 변경
      - **Blocking** 방식의 경우 메시지 발송 이후 디스코드 측의 응답이 돌아올 때까지 대기해야 했기 때문에, 유휴 시간을 줄이고자 비동기 방식으로 메시지 발송을 구현
</details>

