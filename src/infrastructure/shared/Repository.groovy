package infrastructure.shared

trait Repository<T, ID> {
    abstract T find(ID identifier)
    abstract void add(T obj)
}