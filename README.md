# DataStructure
Java 로 구현하는 자료구조

# **LinkedList란?**

연결 리스트(LinkedList)는 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식의 자료구조입니다. 데이터를 담고 있는 노드들이 연결되어 있고, 노드의 포인터가 이전 노드와 다음 노드와의 연결을 담당합니다. Node는 LinkedList에 객체를 추가하거나 삭제하면 앞뒤 링크만 변경되고 나머지 링크는 변경되지 않습니다. 중간에 데이터를 추가나 삭제하더라도 전체의 인덱스가 한 칸씩 뒤로 밀리거나 당겨지는 일이 없기에 ArrayList에 비해서 데이터의 추가나 삭제가 용이하나, 인덱스가 없기에 특정 요소에 접근하기 위해서는 순차 탐색이 필요로 하여 탐색 속도가 떨어진다는 단점이 있습니다. 그러므로 탐색 또는 정렬을 자주 하는 경우엔 배열을 사용하고 데이터의 추가/삭제가 많은 경우 연결 리스트를 사용하는 것이 좋습니다.

![https://blog.kakaocdn.net/dn/bqsySc/btqEk1stewE/tnty2kV69c7l45eyUO3Jh0/img.png](https://blog.kakaocdn.net/dn/bqsySc/btqEk1stewE/tnty2kV69c7l45eyUO3Jh0/img.png)

ArrayList는 내부 배열에 객체를 저장해서 인덱스로 관리하는데 비해서 LinkedList는 위와 같이 인접 참조를 링크해서 체인처럼 관리합니다.

# **HashTable란?**

## 1. 해쉬 구조

- Hash Table : 키 (Key)에 데이터(Value)를 저장하는 데이터 구조
    - Key를 통해 바로 데이터를 받아올 수 있으므로, 속도가 획기적으로 빨라짐
    - 보통 배열로 미리 Hash Table 사이즈 만큼 생성 후에 사용 (공간과 탐색 시간을 맞바꾸는 기법)

![https://blog.kakaocdn.net/dn/bKcqCB/btq5Er7EXXd/NCOoU9kvrGG0MZyEfbdmCK/img.png](https://blog.kakaocdn.net/dn/bKcqCB/btq5Er7EXXd/NCOoU9kvrGG0MZyEfbdmCK/img.png)

## 2. 알아둘 용어

- 해쉬(Hash) : 임의 값을 고정 길이로 변환하는 것
- 해쉬 테이블 (Hash Table) : 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
- 해싱 함수 (Hashing function) : Key에 대해 산술 연산을 이용해 데이터 위치를 찾을 수 있는 함수
- 해쉬 값 (Hash Value) 또는 해쉬 주소 (Hash Address) : Key를 해싱 함수로 연산해서, 해쉬 값을 알아내고, 이를 기반으로 해쉬 테이블에서 해당 Key에 대한 데이터 위치를 일관성 있게 찾을 수 있음
- 슬롯 (Slot) : 한 개의 데이터를 저장할 수 있는 공간
- 저장할 데이터에 대해 Key를 추출할 수 있는 별도 함수도 존재할 수 있음

# **Tree 란?**
## 1. 트리(Tree) 구조

- 트리 : Node 와 Branch를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조
- 실제로 어디에 많이 사용되나?
    - 트리 중 이진 트리 (Binary Tree)형태의 구조로, 탐색(검색) 알고리즘 구현을 위해 많이 사용됨

## 2. 이진 트리와 이진 탐색 트리 (Binary Search Tree)

- 이진 트리 : 노드의 최대 Branch가 2 인 트리
- 이진 탐색 트리 (BInary Search Tree, BST) : 이진 트리에 다음과 같은 추가적인 조건이 있는 트리
    - 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음

![image](https://user-images.githubusercontent.com/56079997/155874215-cf469098-bda0-4bbe-a526-b1e6a111e9a5.png)

## 3. 자료 구조 이진 탐색 트리의 장점과 주요 용도

- 주요 용도 : 데이터 검색 (탐색)
- 장점 : 탐색 속도를 개선할 수 있음

### 이진 트리와 정렬된 배열간의 탐색 비교

![image](https://user-images.githubusercontent.com/56079997/155874226-cd7313c8-4595-4c1a-9ade-e0c99a30c462.png)

## 5. 트리 노드 삭제

### 5.1 Leaf Node 삭제

- Leaf Node : Child Node 가 없는 Node
- 삭제할 Node의 Parent Node가 삭제할 Node를 가리키지 않도록 한다.

![image](https://user-images.githubusercontent.com/56079997/155874235-7b94207d-0643-4281-8e14-b92415cf5d6c.png)

### 5.2 Child Node가 하나인 Node 삭제

- 삭제할 Node의 Parent Node가 삭제할 Node의 Child Node를 가리키도록 한다.

![image](https://user-images.githubusercontent.com/56079997/155874242-c0270fc5-2782-4c16-bf1d-4f5042b109dd.png)

### 5.3 Child Node 가 두 개인 Node 삭제

- 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
- 삭제할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent Node가 가리키도록 한다.

![image](https://user-images.githubusercontent.com/56079997/155874250-61441431-b5e8-41f6-a5a4-9838b912815a.png)

### 삭제할 Node의 오른쪽 자식중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키게 할 경우

1. 삭제할 Node의 오른쪽 자식 선택
2. 오른쪽 자식의 가장 왼쪽에 있는 Node를 선택
3. 해당 Node를 삭제할 Node의 Parent Node의 왼쪽 Branch가 가리키게 함
4. 해당 Node의 왼쪽 Branch가 삭제할 Node의 왼쪽 Child Node를 가리키게 함
5. 해당 Node의 오른쪽 Branch가 삭제할 Node의 오른쪽 Child Node를 가리키게 함
6. 만약 해당 Node가 오른쪽 Child Node를 가지고 있었을 경우에는, 해당 Node의 본래 Parent Node의 왼쪽 Branch가 해당 오른쪽 Child Node를 가리키게 함

# Set 컬렉션 클래스

## Set 인터페이스를 구현한 모든 Set 컬렉션 클래스는 다음과 같은 특징을 가집니다.

1. 요소의 저장 순서를 유지하지 않습니다.

2. 같은 요소의 중복 저장을 허용하지 않습니다.

## 대표적인 Set 컬렉션 클래스에 속하는 클래스는 다음과 같습니다.

### HashSet<E>
### TreeSet<E>
    
# **Map 컬렉션 클래스**

- Map 인터페이스는 Collection 인터페이스와는 다른 저장 방식을 가집니다.

- Map 인터페이스를 구현한 Map 컬렉션 클래스들은 키와 값을 하나의 쌍으로 저장하는 방식(key-value 방식)을 사용합니다.

- 여기서 키(key)란 실질적인 값(value)을 찾기 위한 이름의 역할을 합니다.

## **Map이란?**

- Map은 리스트나 배열처럼 순차적으로(sequential) 해당 요소 값을 구하지 않고 key를 통해 value를 얻는다.
- 맵(Map)의 가장 큰 특징이라면 key로 value를 얻어낸다는 점이다.
- **특징**

**1. 요소의 저장 순서를 유지하지 않습니다.**

**2. key :  중복을 허용  X**

**value :  중복은 허용 O**
## 대표적인 Map 컬렉션 클래스에 속하는 클래스는 다음과 같습니다.

### HashMap<E>
### TreeMap<E>
