package springStudy.core.singleton;

public class SingletonService {
    // 자기자신 static으로 호출
    private static final SingletonService instance = new SingletonService();

    // 조회
    public static SingletonService getInstance(){
       return instance;
    }

    // pricate 생성자
    private SingletonService(){
    }

    public void logic(){
       System.out.println("싱글톤 객체 로직 호출");
    }
}
