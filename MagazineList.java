/**
 * MagazineList.java  --A program to represent a collection of magazine.
 * @author				Lewis/Loftus
 * @author				Ratna Lama / King Arthur Alagao
 * @version   			1.0
 * @since     			12/03/2017
*/

public class MagazineList {

	private MagazineNode list; // head pointer

	/**
	* Sets up an initially empty list of magazines.
	*/
	public MagazineList() {
		list = null;

	} // end MagazineList()

	/**
	* Inserts each magazine lexigraphically into the list.
	* If a magazine already exists in list, do not insert it.
	* @parm 	mag 	refrence to a magazine object
	*/
	public void insert(Magazine mag) {
        MagazineNode newNode = new MagazineNode(mag); 
        MagazineNode current = list;
        MagazineNode after;
        int count = 0;

        if (list == null) {
          list = newNode;

      	}else if(current.magazine.compareTo(mag) > 0) {		//add to beginning
            newNode.next = current;
            list = newNode;

        }else if(current.magazine.compareTo(mag) < 0 && current.next == null) {
            current.next = newNode;
            list = current;

        }else if(current.magazine.compareTo(mag) < 0) { 	// add to end
            
            while(current.next == null || count == 0) {                                
                
                if(current.next.magazine.compareTo(mag) > 0) {
                    after = current.next;
                    newNode.next = after;
                    current.next = newNode;
                    current = current.next;
                    count++;

                }else {
                    current = current.next;

                } // end if-else

                if(current.next == null 
                        && current.magazine.compareTo(mag) < 0) {
                    current.next = newNode;
                    count++;                        
                } // end if
            } // end while loop
        } // end if
    } // end insert()
	

	/**
	* Creates a new MagazineNode object and adds it to the end of 
	* the linked list.
	* @parm 	mag 	reference to Magazine class object
	*/
	public void add(Magazine mag) {
		MagazineNode node = new MagazineNode(mag);
		MagazineNode current; 	// helper

		if(list == null){
			list = node;
		}else {
			current = list;
			while(current.next != null){
				current = current.next; 	// next list
			} // end while loop

			current.next = node;
		} // end if - else

	} // end add()

	/**
	* Returns this list of magazines as a string
	* @return 	result  the list of magazines to return
	*/
	public String toString() {
		
		String result = "";
		MagazineNode current = list;  // Refrence to first object

		while(current != null) {
			result += current.magazine + "\n";
			current = current.next; 	// next magazine
			
		} // end while loop()

		return result;

	} // end toString()

	
	/**
	* Deletes all magazines fromt the list.
	*/
	public void deleteAll() {

		list = null;	// Derefrences the head pointer 
						// hence becomes eligible candidate for grabage collection

	} // end deleteAll()


	/**
	* Deletes a magazine if it is in the list. If user tries 
	* to clear an already empty list then does nothing. 
	* Also if the list contains magazine, but the user 
	* wants to delete the magazine that is not in the list, then
	* throws null pointer exception.
	* @parm  	mag 		refrence to a magazine object
	*/

	public void delete(Magazine mag)
    {
        MagazineNode current = list, previous = null;
        
        if(list == null) {
            System.out.println("There is no magazine to delete.");

        }else {

            if (current.magazine.compareTo(mag) == 0 
                    && current.next == null) { 
                list = null;

        	}
            if (current.magazine.compareTo(mag) == 0) {
                current = current.next; 
                list = current;

            }
            else {
            	
            	while (current != null && current.magazine.compareTo(mag) != 0) { 
                    previous = current; 
                    current = current.next;

                } // end while loop

                previous.next = current.next; 
                current.next = previous;

            } // end if-else
        } // end if                              
    } // end delete()



	/**
	* An inner class that represents a node in the magazine list.
	* The public variables are accessed by the MagazineList class.
	*/
	private class MagazineNode {


		public Magazine magazine;
		public MagazineNode next;  //

		/**
		* Sets up the node.
		* @parm 	mag 	reference to Magazine class object
		*/
		public MagazineNode(Magazine mag) {
			magazine = mag;
			next = null;

		} // end MagazineNode()

	} // end MagazineNode inner class

} // end MagazineList class