package dao;

import domain.Television;
import org.hibernate.query.Query;

import java.util.List;

public class TelevisionDao extends BaseDaoImpl<Television, Integer> {
    public TelevisionDao() { super(Television.class);}

    public List<Television> getAllByTypeLed (String typeLed) {
        Query q = getSession().createQuery("FROM Television WHERE Television.typeLed = \"" + typeLed + "\"");
        return q.list();
    }
}
