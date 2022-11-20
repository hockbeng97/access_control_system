import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {AddAccessModel} from "../model/add-access.model";

@Injectable()
export class AccessValidateService {
  static readonly URL = 'http://localhost:8082/rest/feature';

  constructor(private http: HttpClient) {
  }

  getCanAccessByEmailAndFeatureName(email: string, featureName: string): Observable<string> {
    let params = new HttpParams();
    params = params.append("email", email).append("featureName", featureName);

    return this.http.get<string>(`${AccessValidateService.URL}/get-can-access-by-email-and-feature-name`, {params: params});
  }

  addAccess(accessModel: AddAccessModel): Observable<string> {
    const headers = { 'content-type': 'application/json'}

    return this.http.post<string>(`${AccessValidateService.URL}/add-access`, accessModel, {headers: headers});
  }

  updateAccess(accessModel: AddAccessModel): Observable<string> {
    const headers = { 'content-type': 'application/json'}

    return this.http.post<string>(`${AccessValidateService.URL}/update-access`, accessModel, {headers: headers});
  }


  addOrUpdateAccess(accessModel: AddAccessModel): Observable<string> {
    const headers = { 'content-type': 'application/json'}

    return this.http.post<string>(`${AccessValidateService.URL}/add-or-update-access`, accessModel, {headers: headers});
  }

}
