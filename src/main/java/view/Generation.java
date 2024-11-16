package view;

import java.util.ArrayList;

public class Generation {
    private ArrayList<Member> members = new ArrayList<>();

    public Generation() {
        members.add(new Member("Lê Đình Chinh"));
        members.add(new Member("Lê Công Huy"));
        members.add(new Member("Nguyễn Duy Vũ"));
        members.add(new Member("Nguyễn Nhật Linh"));
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}