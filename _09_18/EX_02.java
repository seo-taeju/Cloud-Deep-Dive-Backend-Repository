void main() {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    /*for (Integer i : list) {
        if(i % 2 == 1) {
            list.remove(i);
        }
    }*/
    System.out.println("원본 리스트: " + list);//원본 리스트

    Iterator<Integer> it = list.iterator();
    while (it.hasNext()) { //있는지 확인
        int n = it.next(); // 옮기기
        if (n % 2 == 1) { //홀수만 제거
            it.remove();
        }
    }

    System.out.println("홀수 제거 후 = " + list); //after 리스트
}

/**
 * ConcurrentModificationException이 발생하는 이유
 * for-each 루프는 내부적으로 **반복자(Iterator)**를 사용해요.
 * 이 반복자는 리스트를 순회하는 동안 **"리스트의 구조가 변하지 않을 것"**이라고 가정하고 동작하죠.
 * 그런데 루프를 돌면서 remove() 메서드를 통해 리스트의 크기를 직접 변경하면, 반복자의 '예상'과 실제 리스트의 '상태'가 달라지게 돼요.
 *
 * 이런 상황이 발생하면, 자바는 "잠깐! 내가 알고 있던 리스트가 아니네?"라고 생각하고
 * ConcurrentModificationException을 발생시켜서 개발자에게 **"반복문을 돌면서 리스트를 함부로 수정하지 마세요!"**라고 경고하는 거죠.
 * 마치 누군가 쇼핑 목록을 보고 있는데, 옆에서 몰래 목록을 지우거나 추가하면 혼란이 생기는 것과 같아요.
 *
 * */

/**
 * 해결 방법
 * 이 문제를 해결하는 가장 안전하고 좋은 방법은 Iterator가 제공하는 remove() 메서드를 사용하는 거예요.
 * Iterator의 remove() 메서드는 반복자가 리스트의 상태를 제대로 인지하고 있기 때문에 안전하게 요소를 삭제할 수 있죠.
 * */