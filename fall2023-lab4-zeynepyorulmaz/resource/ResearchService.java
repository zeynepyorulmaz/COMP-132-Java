package resource;

import java.util.ArrayList;

public class ResearchService {
	 protected String serviceName;
	 protected ArrayList <Researcher> researchers;
	 protected ArrayList <Resource> resource;
	 
	 
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public ArrayList<Researcher> getResearchers() {
		return researchers;
	}
	public void setResearchers(ArrayList<Researcher> researchers) {
		this.researchers = researchers;
	}
	public ArrayList<Resource> getResource() {
		return resource;
	}
	public void setResource(ArrayList<Resource> resource) {
		this.resource = resource;
	}
	
	public ResearchService(String serviceName) {
	    this.serviceName = serviceName;
	    this.researchers = new ArrayList<>();
	    this.resource = new ArrayList<>();
		
	}
	public void addResource(Resource m) {
	    resource.add(m);
	}

	
	public boolean addResearcher(Researcher researcher) {
	    if (researchers != null) {
	        for (Researcher r : researchers) {
	            if (r.getResearcherName().equals(researcher.getResearcherName())) {
	                System.out.println("Researcher with the same researcherName already exists.");
	                return false;
	            }
	        }
	    }
	    researchers.add(researcher);
	    return true;
	}

	private Researcher getMostSimilarResearcher(Researcher researcher) {
		// en çok ortak like'ı olan researcherı returnleyecek
		double temp =0;
		Researcher result = null;
		for (int i=0; i< researchers.size(); i++) {

			if (researcher.measureSimilarityWith(researchers.get(i))> temp) {
				temp = researcher.measureSimilarityWith(researchers.get(i));
				result = researchers.get(i);

			}
			
		}
		return result;
	}
	
	public Paper recommendPaperBySimilarResearcher(Researcher researcher) {
		/* A method that will recommend a Paper to the researcher that a similar researcher liked.
		 * Use getMostSimilarResearcher method to find the researcher method that will recommend a paper from
		 *  and return a paper that a similar researcher has liked and the given researcher has not downloaded.
		 *  Also, print the name of the most similar researcher with the similarity score inside the method.
		 *   The recommended paper should be the first one in the list that a similar researcher has liked,
		 *    and the current one hasn’t been downloaded yet.*/
		Researcher similarR = getMostSimilarResearcher(researcher);
		
		if (similarR != null) {
            System.out.println("Most similar researcher is " + similarR.getResearcherName() +
                    " with a score of " + researcher.measureSimilarityWith(similarR));
		for (int i = 0;i< similarR.getLikedPapers().size(); i++) {
			
				//if (!(researcher.getDownloaded().contains(similarR.getLikedPapers().get(i)))) {
			for (int j = 0; j<researcher.getDownloaded().size(); j++) {

				if (researcher.getDownloaded().get(j) != similarR.getLikedPapers().get(i)) {
					return similarR.getLikedPapers().get(i);
				}
				}
		}
			}
		return null;
			
		}
	
	
	public Resource recommendByField(Researcher researcher) {
		/* A method that will return a Resource (Paper or ProceedingBook) with the researcher's favorite field.
		 *  Note that the recommendation should not be downloaded before by the researcher. 
		 *  Also, print the favorite field of the researcher inside the method.*/
	    String favoriteField = researcher.getFavoriteField();

	    
	    System.out.println("Your favorite field is:" + favoriteField);

	    for (Resource resource : researcher.getDownloaded()) 
	        if (resource.getField().equals(favoriteField)) {
	            return resource;
	        }
	    

	    return null;
	}
}
