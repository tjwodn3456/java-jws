package com.example.myapp;

import java.util.ArrayList;

public class BadMain {
    public static void main(String[] args) {
        // 1. 해커가 외부에서 멤버 리스트를 만든다.
        ArrayList<String> initialMembers = new ArrayList<>();
        initialMembers.add("Kim");
        initialMembers.add("Park");

        // 2. 이 리스트로 팀을 생성한다.
        LeakyTeam team = new LeakyTeam(initialMembers);
        System.out.println("최초 팀원: " + team.getMembers());

        // 3. 공격 1: 생성 후, 해커가 가지고 있던 '원본' 리스트를 수정한다.
        System.out.println("\n>> 외부에서 원본 리스트에 'Lee' 추가...");
        initialMembers.add("Lee");
        System.out.println("공격 후 팀원: " + team.getMembers()); // 헉! 팀 내부 멤버가 바뀌었다!

        // 4. 공격 2: Getter를 통해 내부 리스트의 '열쇠'를 얻어온다.
        ArrayList<String> internalMembers = team.getMembers();
        System.out.println("\n>> Getter로 얻은 리스트에 'Choi' 추가...");
        internalMembers.add("Choi");
        System.out.println("2차 공격 후 팀원: " + team.getMembers()); // 또 바뀌었다! 불변성 완전 실패.
    }
}