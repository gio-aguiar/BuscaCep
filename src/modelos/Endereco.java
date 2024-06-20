package modelos;

import com.google.gson.annotations.SerializedName;

public class Endereco {
    @SerializedName("cep")
    public String cep;
    @SerializedName("logradouro")
    public String logradouro;
    @SerializedName("complemento")
    public String complemento;
    @SerializedName("bairro")
    public String bairro;
    @SerializedName("uf")
    public String uf;
    @SerializedName("ibge")
    public int ibge;
    @SerializedName("ddd")
    public int ddd;

    public Endereco() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getIbge() {
        return ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "Cep digitado: " + this.getCep() + ". Logradouro: " + this.getLogradouro() + ". Complemento: "
                + this.getComplemento() + ". Bairro:" + this.getBairro() + ". UF: " + this.getUf() + ". DDD: " + this.getDdd();
    }
}
