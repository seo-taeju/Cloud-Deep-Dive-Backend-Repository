void main(){

    hard();

}

void easy(){
    HashMap<String,Integer> map = new HashMap<>();
    map.put("seo",20);
    map.put("joo",30);
    map.put("tae",40);

    System.out.println("내 나이: "+map.get("seo"));
    System.out.println("내 나이: "+map.get("joo"));
    System.out.println("내 나이: "+map.get("tae"));
    System.out.println(map.keySet());
}

void normal(){
    Map<String,String> map = new HashMap<>();
    map.put("서울","대한민국");
    map.put("도쿄","일본");
    map.put("베이징","중국");
    map.put("베를린","독일");
    boolean tr = map.containsKey("도쿄");
    if(tr){
        System.out.println("도쿄는 이미 존재합니다.");
    }
    Iterator<String> it = map.keySet().iterator();
    while(it.hasNext()){
        String key = it.next();
        String value = map.get(key);
        System.out.print(key+":"+value);
    }

    //최적화
    for(Map.Entry<String,String> entry : map.entrySet()){
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
}
void hard(){
    HashMap<String,List<String>> map = new HashMap<>();
    map.put("과일",new ArrayList<>(Arrays.asList("사과","바나나","사과")));
    map.put("야채",new ArrayList<>(Arrays.asList("당근","양파","당근")));

    System.out.println("중복 제거 후: "+map.entrySet());
    // 새로운 맵 (중복 제거용), set용으로 만들기
    Map<String, Set<String>> newMap = new HashMap<>();

    for(Map.Entry<String,List<String>> entry : map.entrySet()){
        String key = entry.getKey();
        List<String> value = entry.getValue();
        Set<String> set = new HashSet<>(value);
        newMap.put(key,set);
    }

    System.out.println("중복 제거 후: "+newMap.entrySet());
    System.out.println("모든 키: "+newMap.keySet());



    /*Set<String> keys1 = new HashSet<>(map.get("과일"));
    Set<String> keys2 = new HashSet<>(map.get("야채"));

    map.put("과일",keys1);
    for(Map.Entry<String,List<String>> entry : map.entrySet()){
        System.out.println("중복 제거 후 : "+ map.entrySet());
        System.out.println("모든 키 : "+map.keySet());
    }*/

}