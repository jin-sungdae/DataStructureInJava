# DataStructure
Java 로 구현하는 자료구조

### **LinkedList란?**

연결 리스트(LinkedList)는 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식의 자료구조입니다. 데이터를 담고 있는 노드들이 연결되어 있고, 노드의 포인터가 이전 노드와 다음 노드와의 연결을 담당합니다. Node는 LinkedList에 객체를 추가하거나 삭제하면 앞뒤 링크만 변경되고 나머지 링크는 변경되지 않습니다. 중간에 데이터를 추가나 삭제하더라도 전체의 인덱스가 한 칸씩 뒤로 밀리거나 당겨지는 일이 없기에 ArrayList에 비해서 데이터의 추가나 삭제가 용이하나, 인덱스가 없기에 특정 요소에 접근하기 위해서는 순차 탐색이 필요로 하여 탐색 속도가 떨어진다는 단점이 있습니다. 그러므로 탐색 또는 정렬을 자주 하는 경우엔 배열을 사용하고 데이터의 추가/삭제가 많은 경우 연결 리스트를 사용하는 것이 좋습니다.

![https://blog.kakaocdn.net/dn/bqsySc/btqEk1stewE/tnty2kV69c7l45eyUO3Jh0/img.png](https://blog.kakaocdn.net/dn/bqsySc/btqEk1stewE/tnty2kV69c7l45eyUO3Jh0/img.png)

ArrayList는 내부 배열에 객체를 저장해서 인덱스로 관리하는데 비해서 LinkedList는 위와 같이 인접 참조를 링크해서 체인처럼 관리합니다.

### **HashTable란?**

# 1. 해쉬 구조

- Hash Table : 키 (Key)에 데이터(Value)를 저장하는 데이터 구조
    - Key를 통해 바로 데이터를 받아올 수 있으므로, 속도가 획기적으로 빨라짐
    - 보통 배열로 미리 Hash Table 사이즈 만큼 생성 후에 사용 (공간과 탐색 시간을 맞바꾸는 기법)

![https://blog.kakaocdn.net/dn/bKcqCB/btq5Er7EXXd/NCOoU9kvrGG0MZyEfbdmCK/img.png](https://blog.kakaocdn.net/dn/bKcqCB/btq5Er7EXXd/NCOoU9kvrGG0MZyEfbdmCK/img.png)

# 2. 알아둘 용어

- 해쉬(Hash) : 임의 값을 고정 길이로 변환하는 것
- 해쉬 테이블 (Hash Table) : 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
- 해싱 함수 (Hashing function) : Key에 대해 산술 연산을 이용해 데이터 위치를 찾을 수 있는 함수
- 해쉬 값 (Hash Value) 또는 해쉬 주소 (Hash Address) : Key를 해싱 함수로 연산해서, 해쉬 값을 알아내고, 이를 기반으로 해쉬 테이블에서 해당 Key에 대한 데이터 위치를 일관성 있게 찾을 수 있음
- 슬롯 (Slot) : 한 개의 데이터를 저장할 수 있는 공간
- 저장할 데이터에 대해 Key를 추출할 수 있는 별도 함수도 존재할 수 있음


