package com.imse.imse.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mitarbeiter")
public class Mitarbeiter {

        @Id
        private int sv_nummer;

		private String name;

		private String nummer;

		private String e_mail;

        @ManyToOne
        private Firma firma;
		
		public Mitarbeiter() {}

		public Mitarbeiter(String name, String nummer, String e_mail, int sv) {
			this.e_mail = e_mail;
			this.nummer = nummer;
			this.name = name;
			this.sv_nummer = sv;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getNummer() {
			return nummer;
		}
		public void setNummer(String nummer) {
			this.nummer = nummer;
		}

		public String getE_mail() {
			return e_mail;
		}
		public void setE_mail(String e_mail) {
			this.e_mail = e_mail;
		}

		public int getSv_nummer() {
			return sv_nummer;
		}
		public void setSv_nummer(int sv_nummer) {
			this.sv_nummer = sv_nummer;
		}

        public Firma getFirma() {
            return firma;
        }
        public void setFirma(Firma firma) {
            this.firma = firma;
        }
}
