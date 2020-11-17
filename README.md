
# Teros (All-In-One Data Platform)

## Overview

Teros 는 Cloud Foundary 기반의 마이크로 서비스 애플리케이션 플랫폼이다.
API-Management 및 On-Premise 와 Cloud 환경의 데이터를 통합을 지원하여, 점차 고도화되고 있는 IT 의 복잡한 인프라 및 서비스 요구사항에 대한 솔루션을 제공해 주는 통합 플랫폼이다.

<br/>

 ## Application 구성

#### Dashboard

Administor & Developer 를 위한 API 개발, 플로우 디자인, 모니터링 등의 통합 서비스를 제공하는 HTML5 기반의 통합 대시보드이다.

#### Central Server

Teros 플랫폼에서 제공되는 모든 Application 에 대한 명령 발행 및 관리를 제공하는 중앙 서버. 기능 확장을 위한 모니터링, 통계 서비스 등의 모듈을 포함한다.
<br/>
#### API-Control-Manager

API-Gateway 에 대해서 API Router Rule 배포 및 관리 기능을 제공하는 Manager이다.
<br/>
#### API-Gateway

일반 End-User 에 대한 API 서비스를 제공한다. 정의된 API-Endpoint 는 Teros 의 Data-Service 서비스 혹은 다른 Restful 서비스와 연계할 수 있다.
<br/>
#### Data-Control-Manager

Data-Service 에 대해서 Data Flow 배포 및 관리 기능을 제공하는 Manager 이다.
<br/>
#### Data-Service

다채로운 환경, 애플리케이션, 데이터에 대한 통합을 제공하는 서비스를 제공한다.
<br/>
