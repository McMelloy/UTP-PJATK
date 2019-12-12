package extensions;

import java.util.HashSet;


    public class SubjectExt {
        public static HashSet<SubjectExt> depHashSet = new HashSet<SubjectExt>();

        public void addToPersonHashSet(SubjectExt e) {
            depHashSet.add(e);
        }
    }


