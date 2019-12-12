package classes;

import java.util.Objects;

public class StudentGroup {

    private Group _group;

    public Group get_group() {
        return _group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return _group == that._group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_group);
    }
}
