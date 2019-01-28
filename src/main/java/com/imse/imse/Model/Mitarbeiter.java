package com.imse.imse.Model;

import org.springframework.data.annotation.Id;

public class Mitarbeiter {

        @Id
        private int _id;

		private String name;

		private String nummer;

		private String e_mail;

        private Firma firma;
		
		public Mitarbeiter() {}

		public Mitarbeiter(String name, String nummer, String e_mail, int sv, Firma firma) {
			this.e_mail = e_mail;
			this.nummer = nummer;
			this.name = name;
			this._id = sv;
			this.firma = firma;
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
			return _id;
		}
		public void setSv_nummer(int sv_nummer) {
			this._id = sv_nummer;
		}

        public Firma getFirma() {
            return firma;
        }
        public void setFirma(Firma firma) {
            this.firma = firma;
        }
}
