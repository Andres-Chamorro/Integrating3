package model;

public abstract class BibliographicResources {
    private String id;
    private String nameResource;
    private int numPages;
    private String URL;
    private double valueResource;
    protected int numPagesRead;

    public BibliographicResources(String id, String nameResource, int numPages, String URL, double valueResource) {
        this.id = id;
        this.nameResource = nameResource;
        this.numPages = numPages;
        this.URL = URL;
        this.valueResource = valueResource;
        this.numPagesRead = 0;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameResource() {
        return this.nameResource;
    }

    public void setNameResource(String nameResource) {
        this.nameResource = nameResource;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public double getValueResource() {
        return this.valueResource;
    }

    public void setValueResource(double valueResource) {
        this.valueResource = valueResource;
    }

    public int getNumPagesRead() {
        return this.numPagesRead;
    }

    public void setNumPagesRead(int numPagesRead) {
        this.numPagesRead = numPagesRead;
    }

    public boolean verifyUserExists(String id, BibliographicResources[] resources) {
        for (int i = 0; i < resources.length; i++) {
            if (resources[i] != null && resources[i].getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

}