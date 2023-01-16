import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PersonComponent} from './person/person.component';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './auth/auth-guard.service';
import {PersonEditComponent} from './person/edit/person-edit.component';

const routes: Routes = [
    {path: '', component: PersonComponent, canActivate: [AuthGuard]},
    {path: 'persons', component: PersonComponent, canActivate: [AuthGuard]},
    {path: 'persons/:id', component: PersonEditComponent, canActivate: [AuthGuard]},
    {path: 'login', component: LoginComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
