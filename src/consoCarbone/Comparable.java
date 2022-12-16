package consoCarbone;
/**Dans cet interface on demande de comparer deux instances du type generique T on comparera les impacts
 * 
 * @author theo4
 *
 * @param <T> 
 */
public interface Comparable<T> {
	
	public int compare(T o1, T o2);
		
}
