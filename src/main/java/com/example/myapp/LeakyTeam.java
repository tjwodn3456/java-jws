package com.example.myapp;

import java.util.ArrayList;

public final class LeakyTeam {
    // final로 선언했지만, list 자체가 가리키는 '내용물'은 변경 가능하다.
    private final ArrayList<String> members;

    // 생성자: 외부에서 만든 list의 '참조값(열쇠)'을 그대로 받는다. (문제 지점 1)
    public LeakyTeam(ArrayList<String> members) {
        this.members = members;
    }

    // Getter: 내부 list의 '참조값(열쇠)'을 그대로 외부에 넘겨준다. (문제 지점 2)
    public ArrayList<String> getMembers() {
        return this.members;
    }
}