package myapp.myapp.test;

import lombok.Builder;
import lombok.Getter;

@Getter // Getter 생성
public class Test {
    private String id;
    private String name;

    @Builder // 생성자를 만든 후 그 위에 @Build 어노테이션 적용
    public Test(String id, String name) {
        this.id = id;
        this.name = name;
    }
    Test a = Test.builder()
            .id(id)
            .name(name)
            .build();
}