package model;

public class Guide {
    private StringBuilder str;

    public Guide() {
        str = new StringBuilder("<html><pre>");
        str.append(" - Input theo dạng 9 x 9 <br>");
        str.append(" - Khoảng cách giữa các số là khoảng <br>   trắng <br>");
        str.append(" - Các số bị thiếu điền dấu .");
        str.append("<pre></html>");
    }

    public StringBuilder getStringBuilder() {
        return str;
    }
}