public interface ListInterface {
    public void add(Object obj);
    public void insert(Object obj, int index);
    public void remove(int index) throws ObjectNotFoundException;
    public void replace(int index, Object obj);
    public void replace(Object changed, Object changer);

}
