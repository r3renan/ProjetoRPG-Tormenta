package parser;

public class Ficha {
    
    private String nome;
    private String raca;
    private String classe;
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;
    
    private int modForca;
    private int modDestreza;
    private int modConstituicao;
    private int modInteligencia;
    private int modSabedoria;
    private int modCarisma;
    
    public Ficha(){
        nome = null;
        raca = null;
        classe = null;
        forca = 0;
        destreza = 0;
        constituicao = 0;
        inteligencia = 0;
        sabedoria = 0;
        carisma = 0;
        
        modForca = 0;
        modDestreza = 0;
        modConstituicao = 0;
        modInteligencia = 0;
        modSabedoria = 0;
        modCarisma = 0;
    }

    public int getModForca() {
        return modForca;
    }

    public void setModForca(int modForca) {
        this.modForca = modForca;
    }

    public int getModDestreza() {
        return modDestreza;
    }

    public void setModDestreza(int modDestreza) {
        this.modDestreza = modDestreza;
    }

    public int getModConstituicao() {
        return modConstituicao;
    }

    public void setModConstituicao(int modConstituicao) {
        this.modConstituicao = modConstituicao;
    }

    public int getModInteligencia() {
        return modInteligencia;
    }

    public void setModInteligencia(int modInteligencia) {
        this.modInteligencia = modInteligencia;
    }

    public int getModSabedoria() {
        return modSabedoria;
    }

    public void setModSabedoria(int modSabedoria) {
        this.modSabedoria = modSabedoria;
    }

    public int getModCarisma() {
        return modCarisma;
    }

    public void setModCarisma(int modCarisma) {
        this.modCarisma = modCarisma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }
}
