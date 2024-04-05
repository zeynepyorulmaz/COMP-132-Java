package resource;

import java.util.ArrayList;
import java.util.Collections;

public class Researcher {
	 protected String researcherName;
	 protected ArrayList <Resource> downloaded;
	 protected ArrayList <Resource> liked;
	 
	public String getResearcherName() {
		return researcherName;
	}
	public void setResearcherName(String researcherName) {
		this.researcherName = researcherName;
	}
	public ArrayList<Resource> getDownloaded() {
		return downloaded;
	}
	public void setDownloaded(ArrayList<Resource> downloaded) {
		this.downloaded = downloaded;
	}
	public ArrayList<Resource> getLiked() {
		return liked;
	}
	public void setLiked(ArrayList<Resource> liked) {
		this.liked = liked;
	}
	
	public Researcher(String researcherName) {
	    this.researcherName = researcherName;
	    this.downloaded = new ArrayList<>();
	    this.liked = new ArrayList<>();
		
	}
	
	public void download(Resource m, boolean like) {
		downloaded.add(m);

		m.addNumDwnld(like);
		if (like) {
			liked.add(m);
		}
	}
	
	public ArrayList<Paper> getLikedPapers(){
        ArrayList<Paper> likedPapers = new ArrayList<>();
        for (Resource resource : liked) {
            if (resource instanceof Paper) {
                likedPapers.add((Paper) resource);
            }
        }
        return likedPapers;
    }

	public ArrayList<ProceedingBook> getProceedingBooks(){ //sor typo mu var
        ArrayList<ProceedingBook> likedProceedingBooks = new ArrayList<>();
        for (Resource resource : liked)
        {
            if (resource instanceof ProceedingBook) 
            {
                likedProceedingBooks.add((ProceedingBook) resource);
            }
        }
        return likedProceedingBooks;

		
	}
	public String getFavoriteField() {
		ArrayList<String> fields = new ArrayList<String>();
	    ArrayList<Integer> fieldCounts = new ArrayList<Integer>();
	    

	    
	    for (int i = 0; i < liked.size(); i++) {
	        Resource resource = liked.get(i);
	        String field = resource.getField();

	        
	        int index = fields.indexOf(field);
	        if (index == -1) {
	            fields.add(field);
	            fieldCounts.add(1);
	        } else {
	            
	            fieldCounts.set(index, fieldCounts.get(index) + 1);
	        }
	    }

	    
	    int maxIndex = fieldCounts.indexOf(Collections.max(fieldCounts));

	   
	    return fields.get(maxIndex);
			
			
			
	
		}

	
	public double measureSimilarityWith(Researcher r) {
		//iki tane researcher argument olması gerekmez mi sor?
		double similarity = 0;
		for (int i=0; i< r.getLikedPapers().size(); i++) {
			for (int j=0; j< liked.size(); j++) {
				if (r.getLikedPapers().get(i) == liked.get(j)) {
					similarity++;
				}
			}
			//liked.contains(r.getLikedPapers().get(i));
		}
		
		for (int i=0; i< r.getProceedingBooks().size(); i++) {
			for (int j=0; j< liked.size(); j++) {
				if (r.getProceedingBooks().get(i) == liked.get(j)) {
					similarity++;
				}
			}
			//liked.contains(r.getLikedPapers().get(i));
		}
		
		return similarity;
	}

}
