package com.example.fithub20

import android.provider.ContactsContract.CommonDataKinds.Email

class User {
    var email: String? = null
    var uid: String?= null

    constructor(){}

    constructor(email: String?, uid: String?){
        this.email = email
        this.uid = uid
    }
}
