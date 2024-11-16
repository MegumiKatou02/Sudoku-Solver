import org.junit.Test;

import view.Generation;
import view.Member;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class ProgramTest {
    private Generation gen = new Generation();
    private ArrayList<Member> members = gen.getMembers();

    @Test
    public void testLabels() {
        assertEquals("Lê Đình Chinh", members.get(0).getName());
        assertEquals("Lê Công Huy", members.get(1).getName());
        assertEquals("Nguyễn Duy Vũ", members.get(2).getName());
        assertEquals("Nguyễn Nhật Linh", members.get(3).getName());
    }
}
