package hashtable;

import java.util.LinkedList;
import java.util.HashMap;

public class HashTableMate{
	class Node{
		String key;
		String value;
		public Node(String key, String value){
			this.key = key;
			this.value = value;
		}
		String value(){
			return this.value;
		}
		void value(String value){
			this.value = value;
		}
	}

	// Node형 연결리스트로 선언
	LinkedList<Node>[] data;

	// 자신을 호출하면서 크기를 지정하여 선언
	public HashTableMate(int size){
		this.data = new LinkedList[size];
	}

	// Key값을 통해 HashCode 생성 - 아스키코드 이용
	int gethashCode(String key){
		int hashCode = 0;
		for (char c : key.toCharArray())
			hashCode += c;
		return hashCode;
	}

	// HashCode를 이용해서 Index 지정
	int convertToIndex(int hashCode){
		return hashCode&data.length;
	}

	Node searchKey(LinkedList<Node> list, String key){
		if (list == null)
			return null;
		for (Node node : list){
				if (node.key.equals(key)){
					return node;
			}
		}
		return null;
	}

	// Key를 통한 값 저장
	void set(String key, String value){
		int index = convertToIndex(gethashCode(key));
		LinkedList<Node> list = data[index];
		// 없으면 저장
		if (list == null){
			list = new LinkedList<Node>();
			data[index] = list;
		}

		Node node = searchKey(list, key);

		if (node == null)
			list.addLast(new Node(key, value));
		else
			node.value(value);
		
		System.out.println("hashCode : " + gethashCode(key) + ", index : " + index + ", ");
	}

	//Key를 통한 값 호출
	String get(String key){
		int index = convertToIndex(gethashCode(key));
		LinkedList<Node> list = data[index];

		if (list == null)
			return "Not Found";
		else {
			for (Node n : list){
				if (n.key.equals(key))
					return n.value;
			}
		}
		return null;
	}

	public static void main(String []args){
		HashMap<String, String> map = new HashMap<>();
		map.put("hi", "hello");
		map.put("int", "integer");
		map.put("double", "Double");

		System.out.println(map.get("hi"));
		System.out.println(map.get("int"));
		System.out.println(map.get("double"));
	}
}