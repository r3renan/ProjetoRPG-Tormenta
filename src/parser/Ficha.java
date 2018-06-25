package parser;

public class Ficha {
    
    private String nome;
    private int id_raca;
    private int id_classe;
    private int nivel;
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
        id_raca = 0;
        id_classe = 0;
        nivel = 0;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

    public int getId_raca() {
        return id_raca;
    }

    public void setId_raca(int id_raca) {
        this.id_raca = id_raca;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
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
