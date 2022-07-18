
import java.util.ArrayList;

class Tags {
    private int position, length;
    String next;

    public Tags(int p, int l, String n) {
        position = p;
        length = l;
        next = n;
    }

    int getposition() {
        return position;
    }

    int getlength() {
        return length;
    }

    String getnext() {
        return next;
    }
}

public class DecompressLz77 {

    public static void main(String[] args) {
        String Decom = "";
        ArrayList<Tags> tag = new ArrayList<Tags>();

        Tags t = new Tags(0, 0, "B");
        Tags q = new Tags(0, 0, "a");
        Tags w = new Tags(1, 1, "s");
        Tags e = new Tags(2, 1, "t");
        tag.add(t);
        tag.add(q);
        tag.add(w);
        tag.add(e);
        for (int i = 0; i < tag.size(); i++) {
            if (tag.get(i).getlength() == 0 || tag.get(i).getposition() == 0) {
                Decom = Decom + tag.get(i).getnext();
            } else {
                int s = Decom.length() - tag.get(i).getposition();
                Decom = Decom + Decom.substring(s, s + (tag.get(i).getlength()));
                Decom = Decom + tag.get(i).getnext();
            }
        }

        System.out.println(Decom);

    }

}