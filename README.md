# android-modular-apps

How build modular applications in Android 

## Overview 

- Modules in Android

- Intent & Navigation

- Dependencies

- Gradle & Flavors

- Layers & Clean Architecture

## Sample 

Meetup Android Client

Modules

- User 

- Meetups

- Messages

- Notificaciones

Table of modules

Name | Module  | Package 
------------ | ------------- | ------------- 
App | module-app | com.emedinaa.meetup
User | module-user | com.emedinaa.meetup.user
Meetups | module-group | com.emedinaa.meetup.group
Messages | module-messages | com.emedinaa.meetup.messages
Notifications | module-notification | com.emedinaa.meetup.notification
Core | module-commons | com.emedinaa.meetup.commons
Core | module-domain | com.emedinaa.meetup.domain
Core | module-data | com.emedinaa.meetup.data

  
## References 

- Meetup API [https://www.meetup.com/es-ES/meetup_api/](https://www.meetup.com/es-ES/meetup_api/)

- Clean Architecture [https://github.com/emedinaa/android-clean-architecture](https://github.com/emedinaa/android-clean-architecture)

- Android MVP [https://github.com/emedinaa/android-mvp](https://github.com/emedinaa/android-mvp)
