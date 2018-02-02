/**
 * Magazine.java  --A program to represent a single magazine.
 * @author			Lewis/Loftus
 * @author			Ratna Lama / King Arthur Alagao
 * @version   		1.0
 * @since     		12/03/2017
*/

public class Magazine implements Comparable {

	private String title;

	/**
	* Sets up the new magazine with its title.
	* @parm 	title 	title of the new magazine to set
	*/
	public Magazine(String title) {
		this.title = title;
		
	} // end Magazine()

	/**
	* Returns this magazine as a string.
	* @return 	title  title of the new magazine to return
	*/
	public String toString() {
		return title;

	} // end toString()

	/**
	* Compares this object with the specified object for order.
	* Returns a negative integer, zero, or a positive integer as 
	* this object is less than, equal to, or greater than the specified 
	* object.
	* @parm 	other 		specified object to be compared for order
	* @return 	result 		negative integer if this object is less than the specified object
	*						zero if this object is equal to specified object
	*						a positive integer if this object is greater than the specified object						
	*/

	public int compareTo(Object other) {
		
		int result;
		Magazine otherMagazine = (Magazine)other;
		result = title.compareTo(otherMagazine.title);
		return result;

	} // end compareTo()


	/**
	* Get accecssor provides read access to the magazine title field
	* @return 	title 	the title of the magazine to return
	*/
	public String getTitle() {
		return title;

	} // end getTitle()


} // end Magaine class