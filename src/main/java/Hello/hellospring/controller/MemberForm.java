package Hello.hellospring.controller;

public class MemberForm {
    private String name; // 입력부에서 입력한 값이 넘어온 후 저장

    public String getName() {
        return name; // 해당 이름 꺼낸다
    }

    public void setName(String name) {
        this.name = name; // name 입력 부 값이 들어갈수있게 들어가짐
    }
}
